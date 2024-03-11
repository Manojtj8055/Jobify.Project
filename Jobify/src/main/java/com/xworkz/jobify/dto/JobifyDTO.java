package com.xworkz.jobify.dto;



public class JobifyDTO {
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private String accountType;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	

	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	@Override
	public String toString() {
		return "JobifyDTO [name=" + name + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", phoneNumber=" + phoneNumber + ", accountType=" + accountType + ", gender="
				+ gender + "]";
	}

	public JobifyDTO(String name, String email, String password, String confirmPassword, String phoneNumber,
			String accountType,String gender) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
		this.gender = gender;
	}

	public JobifyDTO() {

	}

}
