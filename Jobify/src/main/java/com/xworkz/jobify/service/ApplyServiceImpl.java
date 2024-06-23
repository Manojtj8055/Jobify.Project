package com.xworkz.jobify.service;

import java.time.LocalDate;
import java.util.List;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.jobify.dto.ApplyEntity;
import com.xworkz.jobify.dto.JobRegisterEntity;
import com.xworkz.jobify.repository.JobifyRepositoryImpl;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private JobifyRepositoryImpl repository;

	@Override
	public JobRegisterEntity getJobDetails(Integer jobID) {
		return repository.getJobsById(jobID);
	}

	@Override
	public boolean applicationsSave(int jobId, int accId, String resume, byte[] resumeData) {
		ApplyEntity applyEntity = new ApplyEntity();
		System.out.println("Found : - " + applyEntity);
		if (applyEntity != null) {

			applyEntity.setJobId(jobId);
			applyEntity.setAccId(accId);
			applyEntity.setResume(resume);
			applyEntity.setData(resumeData);
			applyEntity.setAppliedOn(LocalDate.now());

			boolean savedEntity = repository.saveApplications(applyEntity);
			if (savedEntity == true) {
				return true;
			}
		}
		return false;

	}

	@Override
	public List<ApplyEntity> getApplicationByJobId(int jobId) {
		List<ApplyEntity> applied = repository.fetchApplicationsByJobId(jobId);
		System.out.println("Applications found in service : - " + applied);
		
		return applied;
	}
}
