package com.xworkz.jobify.service;

import java.util.List;

import org.springframework.ui.Model;

import com.xworkz.jobify.dto.JobRegisterDTO;
import com.xworkz.jobify.dto.JobRegisterEntity;
import com.xworkz.jobify.dto.JobifyDTO;

public interface JobRegisterService {

	public String saveJob(JobRegisterDTO dto, Model model, JobifyDTO dto2, String loggedInUserEmail);

	public JobRegisterEntity getJobsById(Integer jobsId);

	List<JobRegisterEntity> getAllActiveJobs();


}
