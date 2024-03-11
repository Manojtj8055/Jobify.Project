package com.xworkz.jobify.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.workz.jobify.dto.JobifyDTO;
import com.workz.jobify.dto.JobifyEntity;
import com.xworkz.jobify.repository.JobifyRepositoryImpl;

@Service
public class JobifyServiceImpl implements JobifyService {

	@Autowired
	private JobifyRepositoryImpl repository;

	@Override
	public boolean validateAndSave(JobifyDTO dto, Model model) {
		if (dto != null) {
			if (dto.getName() != null && !dto.getName().isEmpty()) {
				System.out.println("Name is Valid");

				if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
					System.out.println("Email Valid");

					if (dto.getPhoneNumber().matches("^[0-9]{10}$") ) {
						System.out.println("Phone number Valid");

						if (dto.getPassword().length() >= 6 && dto.getConfirmPassword().length() >= 6
								&& dto.getPassword().equals(dto.getConfirmPassword())) {
							System.out.println("Password Credentials Valid");

							if(!isExists(dto.getEmail())) {
								System.out.println("Email valid");
						}
							
							JobifyEntity entity=new JobifyEntity();
							BeanUtils.copyProperties(dto,entity);
							System.out.println(entity);
							
							entity.setCreatedBy(dto.getEmail());
							entity.setCreatedOn(LocalDate.now());
							
							return repository.save(entity);
							
						} else {
							model.addAttribute("passwordMissMatch", "Password not Match..!");
						}

					} else {
						model.addAttribute("numberMissmatch", "Missmatch..!");
					}

				} else {
					model.addAttribute("notChecking", "Re-Enter Email");
				}
			} else {
				model.addAttribute("notReading", "Cross CheckName...!");
			}
		}

		return false;
	}

//	@Override
//	public List<JobifyEntity> readAll() {
//		
//		return repository.readAll();
//	}
	
	@Override
	public JobifyEntity findByEmail(String email,Model model) {
		
		if(email!=null && !email.isEmpty()) {
			return repository.findByEmail(email);
		}
		model.addAttribute("emailFound", "Email Registered Already..");
		return null;
		
	}

	

	@Override
	public boolean isExists(String email) {
		JobifyEntity find = repository.findByEmail(email);
		if(find!=null) {
			return true;
		}		
		return false;
	}
	
	
	
}
