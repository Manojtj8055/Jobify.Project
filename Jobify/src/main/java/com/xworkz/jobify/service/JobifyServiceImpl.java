package com.xworkz.jobify.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.jobify.Encryption;
import com.xworkz.jobify.dto.JobifyDTO;
import com.xworkz.jobify.dto.JobifyEntity;
import com.xworkz.jobify.repository.JobifyRepositoryImpl;
import com.xworkz.jobify.util.OtpSending;
import com.xworkz.jobify.util.OutlookEmail;

@Service
public class JobifyServiceImpl implements JobifyService {

	@Autowired
	private JobifyRepositoryImpl repository;

	@Autowired
	private Encryption encryption;

	@Autowired
	private OtpSending otpSending;

	@SuppressWarnings("unused")
	@Autowired
	private OutlookEmail outLookEmail;

//	@Autowired
//	private OtpVerificationService otpVerificationService;

	public boolean validateAndSave(JobifyDTO dto, Model model) {
	    if (dto == null) {
	        return false;
	    }

	    // Name Validation
	    if (dto.getName() == null || dto.getName().isEmpty() || !dto.getName().matches("^[A-Za-z\\s]+$")) {
	        model.addAttribute("nameError", "Invalid name. Please enter a valid name.");
	        return false;
	    } else {
	        System.out.println("Name is Valid");
	    }

	    // Email Validation
	    if (dto.getEmail() == null || dto.getEmail().isEmpty() || !dto.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	        model.addAttribute("emailError", "Invalid email. Please enter a valid email.");
	        return false;
	    } else {
	        System.out.println("Email is Valid");
	    }

	    // Phone Number Validation
	    if (dto.getPhoneNumber() == null || !dto.getPhoneNumber().matches("^[6-9]\\d{9}$")) {
	        model.addAttribute("phoneError", "Invalid phone number. Please enter a valid phone number.");
	        return false;
	    } else {
	        System.out.println("Phone number is Valid");
	    }

	    // Password Validation
	    if (dto.getPassword() == null || dto.getConfirmPassword() == null ||
	        dto.getPassword().length() < 6 || dto.getConfirmPassword().length() < 6 ||
	        !dto.getPassword().equals(dto.getConfirmPassword())) {
	        model.addAttribute("passwordError", "Password and confirm password must match and be at least 6 characters long.");
	        return false;
	    } else {
	        String encodedPassword = encryption.encrypt(dto.getPassword());
	        dto.setPassword(encodedPassword);
	        dto.setConfirmPassword(encodedPassword);

	        System.out.println(dto.getPassword());
	        System.out.println("Password Credentials Valid");
	    }

	    // Check if email already exists
	    if (isExists(dto.getEmail(), model)) {
	        model.addAttribute("emailExistsError", "Email already exists. Please use a different email.");
	        return false;
	    } else {
	        System.out.println("Email does not exist, proceeding with registration");
	    }

	    // Send registration email
	    OutlookEmail.sendRegistrationEmail(dto.getEmail(), dto.getName());

	    // Save entity
	    JobifyEntity entity = new JobifyEntity();
	    BeanUtils.copyProperties(dto, entity);
	    System.out.println(entity);

	    entity.setCreatedBy(dto.getEmail());
	    entity.setCreatedOn(LocalDate.now());
	    entity.setLoginStatus("Active");

	    boolean flag = repository.save(entity);
	    System.out.println("Save flag: " + flag);
	    if (flag) {
	        return true;
	    } else {
	        System.out.println("Save operation failed");
	    }

	    return false;
	}


	@Override
	public JobifyEntity findByEmail(String email, Model model) {

		if (email != null && !email.isEmpty()) {

			return repository.findByEmail(email);
		}

		return null;

	}

	@Override
	public boolean isExists(String email, Model model) {
		JobifyEntity find = repository.findByEmail(email);
		if (find != null) {
			if (find.getEmail().equals(email)) {
				model.addAttribute("emailFound", "Email Registered Already..");
				return true;
			}
			return false;
		}
		return false;
	}

	public JobifyEntity login(String email, String password, Model model) {
		if (email != null && !email.isEmpty()) {
			JobifyEntity entity = repository.findByEmail(email);
			System.out.println("Email fetched by " + entity);
			if (entity != null) {
				if (entity.getLoginAttempts() < 3) {
					String storedPassword = entity.getPassword();

					String decodedPassword = encryption.decrypt(storedPassword);
					System.out.println("password fetched " + storedPassword + "password decrypted " + decodedPassword);
					if (decodedPassword.equals(password)) {

						if (entity.getAccountType() != null)
							System.out.println("accountdata fetched " + entity);
						entity.setLoginAttempts(0);
						repository.save(entity);
						return entity;
					} else {
						model.addAttribute("pf", "Wrong Password...");
						entity.setLoginAttempts(entity.getLoginAttempts() + 1);
						if (entity.getLoginAttempts() == 3) {
							entity.setLoginStatus("blocked");
						}
						repository.save(entity);
					}

				} else {
					model.addAttribute("accountBlocked",
							"Account is Blocked to Sign in again click on forgot password..");
				}
			}
			return null;
		}

		return null;
	}

	public JobifyEntity forgotPassword(String email, Model model) {
		if (email != null && !email.isEmpty()) {
			JobifyEntity entity = repository.findByEmail(email);
			if (entity != null) {
				if (entity.getLoginAttempts() == 3) {
					String otp = otpSending.generateOtp();
					otpSending.sendOtpEmail(email, otp);
					entity.setResetOtp(otp);
					repository.save(entity);
					System.out.println("EMAIL SENT TO : " + email + "OTP SENT IS : " + otp);
					return entity;
				}
			}

		}
		return null;
	}

	public boolean verifyOtp(String email, String resetOtp) {
		System.err.println(email);
		JobifyEntity entity = repository.findByEmail(email);
		System.err.println(entity);
		if (entity != null) {
			if (entity.getResetOtp().equalsIgnoreCase(resetOtp)) {

				return true;
			}
		}

		return false;
	}
	
	public boolean resetAccount(String email,String password) {
		JobifyEntity entity = repository.findByEmail(email);
		if(entity != null) {
			String encodedPassword = encryption.encrypt(password);
			entity.setPassword(encodedPassword);
			entity.setResetOtp(null);
			entity.setLoginStatus("Active");
			entity.setLoginAttempts(0);
			entity.setUpdatedBy(email);
			entity.setUpdatedOn(LocalDate.now());
			repository.save(entity);
			
			return true;
		}
		return false;
		
	}
	
	

}
