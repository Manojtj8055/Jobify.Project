package com.xworkz.jobify.repository;

import java.util.List;

import com.workz.jobify.dto.JobifyEntity;

public interface JobifyRepository {

	public boolean save(JobifyEntity entity);
	
//	public List<JobifyEntity> readAll();

	public JobifyEntity findByEmail(String email);
	
	
	
	
	
}
