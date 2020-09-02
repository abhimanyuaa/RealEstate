package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String status = "ACITVE";
	String username;
	String password;
	String address;
	String mobile;
	String firstName;
	String lastName;
	String roles = "ROLE_USER";
	String registrationDate;
	String profilePhoto;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String status, String username, String password, String address, String mobile, String firstName,
			String lastName, String roles, String registrationDate) {
		super();
		this.status = status;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.registrationDate = registrationDate;
	}



	



	public User(int id, String status, String username, String password, String address, String mobile,
			String firstName, String lastName, String roles, String registrationDate, String profilePhoto) {
		super();
		this.id = id;
		this.status = status;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.registrationDate = registrationDate;
		this.profilePhoto = profilePhoto;
	}


	public User(String status, String username, String password, String address, String mobile, String firstName,
			String lastName, String roles, String registrationDate, String profilePhoto) {
		super();
		this.status = status;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.registrationDate = registrationDate;
		this.profilePhoto = profilePhoto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", status=" + status + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", mobile=" + mobile + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", roles=" + roles + ", registrationDate=" + registrationDate + ", profilePhoto=" + profilePhoto
				+ "]";
	}
	







}
