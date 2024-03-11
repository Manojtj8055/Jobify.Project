package com.xworkz.jobify.service;

import java.util.List;

import org.springframework.ui.Model;

import com.workz.jobify.dto.JobifyDTO;
import com.workz.jobify.dto.JobifyEntity;

public interface JobifyService {

	public boolean validateAndSave(JobifyDTO dto,Model model);
	
//	public List<JobifyEntity> readAll();
	
	public boolean isExists(String email);

	public JobifyEntity findByEmail(String email, Model model);
	
	
}
