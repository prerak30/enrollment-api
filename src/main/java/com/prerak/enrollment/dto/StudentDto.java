package com.prerak.enrollment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class StudentDto {

	private int studentId;

	@NotBlank(message = "Username is required")
	private String username;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "(^$|[0-9]{3}-[0-9]{3}-[0-9]{4})", message = "Not valid phone number. e.g. XXX-XXX-XXXX")
	private String phoneNumber;
	
	@NotBlank(message = "First Name is required")
	private String firstName;
	
	@NotBlank(message = "Last Name is required")
	private String lastName;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@NotBlank(message = "Nationality is required")
	private String nationality;
	
	private String enrollmentStatus;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

}
