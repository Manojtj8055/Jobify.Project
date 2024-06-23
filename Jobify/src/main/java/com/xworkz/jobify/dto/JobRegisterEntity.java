package com.xworkz.jobify.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JobRegisteration")
@NamedQuery(name = "jobUploaded", query = "SELECT j FROM JobRegisterEntity j WHERE j.jobProviderEmail = :je")
@NamedQuery(name = "jobId", query = "SELECT i FROM JobRegisterEntity i WHERE i.id = :id")
@NamedQuery(name = "softDeleteById", query = "UPDATE JobRegisterEntity j SET j.deleted = true "
		+ "WHERE j.id = :jobId AND j.jobProviderEmail =:jobProviderEmail")
@NamedQuery(name = "JobRegisterEntity.readAll", query = "Select a FROM JobRegisterEntity a WHERE a.deleted = false")

public class JobRegisterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String company;
	private String role;
	private Integer experience;
	private String skills;
	private long salary;
	private String status;
	private String location;
	private LocalDate jobPosted;
	@Column(name = "job_Provider_Email")
	private String jobProviderEmail;
	@Column(name = "deleted")
	private Boolean deleted = false;
	private String updateBy;
	private LocalDate updateOn;
	

	
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getJobPosted() {
		return jobPosted;
	}

	public void setJobPosted(LocalDate jobPosted) {
		this.jobPosted = jobPosted;
	}

	public String getJobProviderEmail() {
		return jobProviderEmail;
	}

	public void setJobProviderEmail(String jobProviderEmail) {
		this.jobProviderEmail = jobProviderEmail;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public LocalDate getUpdateOn() {
		return getUpdateOn();
	}

	public void setUpdateOn(LocalDate updateOn) {
		this.updateOn = updateOn;
	}

	@Override
	public String toString() {
		return "JobRegisterEntity [id=" + id + ", company=" + company + ", role=" + role + ", experience=" + experience
				+ ", skills=" + skills + ", salary=" + salary + ", status=" + status + ", location=" + location
				+ ", jobPosted=" + jobPosted + ", jobProviderEmail=" + jobProviderEmail + ", deleted=" + deleted + ",updateBy=" + updateBy +",updateOn = " + updateOn +"]";
	}

	public JobRegisterEntity(Integer id, String company, String role, Integer experience, String skills, long salary,
			String status, String location, LocalDate jobPosted, String jobProviderEmail, Boolean deleted, String updateBy, LocalDate updateOn) {

		this.id = id;
		this.company = company;
		this.role = role;
		this.experience = experience;
		this.skills = skills;
		this.salary = salary;
		this.status = status;
		this.location = location;
		this.jobPosted = jobPosted;
		this.jobProviderEmail = jobProviderEmail;
		this.deleted = deleted;
		this.updateBy = updateBy;
		this.updateOn = updateOn;
	}

	public JobRegisterEntity() {

	}

}
