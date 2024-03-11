package com.xworkz.jobify.service;



import org.springframework.ui.Model;

import com.xworkz.jobify.dto.JobifyDTO;
import com.xworkz.jobify.dto.JobifyEntity;

public interface JobifyService {

	public boolean validateAndSave(JobifyDTO dto,Model model);
	
//	public List<JobifyEntity> readAll();
	
	public boolean isExists(String email,Model model);

	public JobifyEntity findByEmail(String email, Model model);
	
	
}
