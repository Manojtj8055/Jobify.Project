package com.xworkz.jobify.util;

import com.xworkz.jobify.dto.JobifyEntity;
import com.xworkz.jobify.repository.JobifyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtpVerificationService {

	private final OtpSending otpSending;
	private final JobifyRepository repository;

	@Autowired
	public OtpVerificationService(OtpSending otpSending, JobifyRepository repository) {
		this.otpSending = otpSending;
		this.repository = repository;
	}

	public void sendOtpAndVerify(String email) {
		// Step 1: Generate OTP and send it via email
		String generatedOtp = otpSending.generateOtp();
		otpSending.sendOtpEmail(email, generatedOtp);

		// Step 2: Save the OTP in the database
		saveOtpInDatabase(email, generatedOtp);
	}

	public boolean verifyOtpAndUpdateAccount(String email, String enteredOtp) {
		// Step 3: Verify the entered OTP
		if (isOtpValid(email, enteredOtp)) {
			// Step 4: Unblock the account and reset login attempts
			unblockAccount(email);
			return true;
		}
		return false;
	}

	private void saveOtpInDatabase(String email, String generatedOtp) {
		JobifyEntity entity = repository.findByEmail(email);
		if (entity != null) {
			entity.setResetOtp(generatedOtp);
			repository.save(entity);
		}
	}

	private boolean isOtpValid(String email, String enteredOtp) {
		JobifyEntity entity = repository.findByEmail(email);
		return entity != null && enteredOtp.equals(entity.getResetOtp());
	}

	private void unblockAccount(String email) {
		JobifyEntity entity = repository.findByEmail(email);
		if (entity != null && "blocked".equals(entity.getLoginStatus())) {
			entity.setLoginStatus("Active");
			entity.setLoginAttempts(0);
			repository.save(entity);
		}
	}
}
