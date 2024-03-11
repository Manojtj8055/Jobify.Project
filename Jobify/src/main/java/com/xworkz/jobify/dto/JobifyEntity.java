package com.xworkz.jobify.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "Register")
@NamedQuery(name = "findByEmail",query = "select entity From JobifyEntity entity where entity.email =:eq")
@NamedQuery(name="updateLoginAttemptByEmail",query="UPDATE JobifyEntity e SET e.loginAttempts = :up WHERE e.email = :email")
//@NamedQuery(name="readAll",query="select entity From JobifyEntity entity =:ra")

public class JobifyEntity { 


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String password;
private String confirmPassword;
private String phoneNumber;
private String accountType;
private String gender;
private String createdBy;
private LocalDate createdOn;
private String updatedBy;
private LocalDate updatedOn;
private int loginAttempts;
private String loginStatus;
private String resetOtp;




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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

public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public LocalDate getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(LocalDate createdOn) {
	this.createdOn = createdOn;
}
public String getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}
public LocalDate getUpdatedOn() {
	return updatedOn;
}
public void setUpdatedOn(LocalDate updatedOn) {
	this.updatedOn = updatedOn;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}


public int getLoginAttempts() {
	return loginAttempts;
}
public void setLoginAttempts(int loginAttempts) {
	this.loginAttempts = loginAttempts;
}
public int getLoginStatus() {
	return loginAttempts;
}
public void setLoginStatus(String loginStatus) {
	this.loginStatus = loginStatus;
}

public String getResetOtp() {
	return resetOtp;
}
public void setResetOtp(String resetOtp) {
	this.resetOtp = resetOtp;
}

public String gender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}



@Override
public String toString() {
	return "JobifyEntity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
			+ ", confirmPassword=" + confirmPassword + ", phoneNumber=" + phoneNumber + ", accountType=" + accountType
			+ ", gender=" + gender + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy="
			+ updatedBy + ", updatedOn=" + updatedOn + ", loginAttempts=" + loginAttempts
			+ ", loginStatus=" + loginStatus + ", resetOtp=" + resetOtp + "]";
}
public JobifyEntity(int id, String name, String email, String password, String confirmPassword, String phoneNumber,
		String AccountType , String createdBy, LocalDate createdOn, String updatedBy, LocalDate updatedOn,String accountType,int loginAttempts,String loginStatus,String resetOtp,String gender) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.phoneNumber = phoneNumber;
	this.accountType =accountType;
	this.createdBy = createdBy;
	this.createdOn = createdOn;
	this.updatedBy = updatedBy;
	this.updatedOn = updatedOn;
	this.loginAttempts=loginAttempts;
	this.loginStatus=loginStatus;
	this.resetOtp=resetOtp;
	this.gender=gender;
}

public JobifyEntity() {
	// TODO Auto-generated constructor stub
}


}