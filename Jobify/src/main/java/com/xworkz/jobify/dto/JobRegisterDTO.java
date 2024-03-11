package com.xworkz.jobify.dto;

public class JobRegisterDTO {
	private Long id;
	private String company;
	private String role;
	private int experience;
	private String skills;
	private long salary;
	private String status;
	private String location;
	private String jobProviderEmail;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	} 
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getExperience() {
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
	
	

	public String getJobProviderEmail() {
		return jobProviderEmail;
	}

	public void setJobProviderEmail(String jobProviderEmail) {
		this.jobProviderEmail = jobProviderEmail;
	}

	@Override
	public String toString() {
		return "JobRegisterDTO [id =" + id+ ",company =" +company + ", role=" + role + ", experience=" + experience + ", skills=" + skills + ", salary="
				+ salary + ", status=" + status + ", location=" + location + ",jobProviderEmail=" + jobProviderEmail +"]";
	}

	public JobRegisterDTO(Long id, String company,String role, int experience, String skills, long salary, String status, String location,String jobProviderEmail) {
		
		this.id = id;
		this.company=company;
		this.role = role;
		this.experience = experience;
		this.skills = skills;
		this.salary = salary;
		this.status = status;
		this.location = location;
		this.jobProviderEmail = jobProviderEmail;

	}

	public JobRegisterDTO() {

	}
}
