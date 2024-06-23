package com.xworkz.jobify.repository;

import java.util.List;

import com.xworkz.jobify.dto.ApplyEntity;
import com.xworkz.jobify.dto.JobRegisterEntity;
import com.xworkz.jobify.dto.JobifyEntity;


public interface JobifyRepository {

	public boolean save(JobifyEntity entity);

	//public List<JobRegisterEntity> allActiveJobs(String loggedInUserEmail);
	
	public List<JobRegisterEntity> allActiveJobs();


	public JobifyEntity findByEmail(String email);

	public List<JobRegisterEntity> getJobsByJobProviderEmail(String jobProviderEmail);
	
	public boolean saveApplications(ApplyEntity apply);
	
	public List<ApplyEntity> fetchApplicationsByJobId(int jobId);

}
