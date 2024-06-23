package com.xworkz.jobify.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "Applications")
@NamedQuery(name = "getApplications", query = "SELECT a FROM ApplyEntity a WHERE a.jobId = :app")
public class ApplyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long listId;

	private int jobId;

	private int accId;

	private String resume;

	@Lob
	private byte[] data;
	
	@Column(name = "Applied_Date")
	private LocalDate appliedOn;
	
	
	public LocalDate getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(LocalDate appliedOn) {
		this.appliedOn = appliedOn;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String toString() {
		return "ApplyEntity [listId " + listId + " ,jobId " + jobId + " ,accId " + accId + " ,resume" + resume
				+ " ,data" + data + " ,appliedOn" + appliedOn + "]";
	}

	public ApplyEntity(Long listId, int jobId, int accId, String resume, byte[] data, LocalDate appliedOn) {
		this.listId = listId;
		this.jobId = jobId;
		this.accId = accId;
		this.resume = resume;
		this.data = data;
		this.appliedOn = appliedOn; 

	}

	public ApplyEntity() {
		// TODO Auto-generated constructor stub
	}
}