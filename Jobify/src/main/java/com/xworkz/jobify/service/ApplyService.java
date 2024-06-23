package com.xworkz.jobify.service;

import java.util.List;

import javax.mail.Multipart;

import org.springframework.web.multipart.MultipartFile;

import com.xworkz.jobify.dto.ApplyEntity;
import com.xworkz.jobify.dto.JobRegisterEntity;

public interface ApplyService {
	
	JobRegisterEntity getJobDetails(Integer jobID);
	
	boolean applicationsSave(int jobId, int accId,String resume,byte[] data);
	
	public List<ApplyEntity> getApplicationByJobId(int jobId);

}
