package com.prerak.enrollment.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SubjectDto {

	@NotBlank(message = "Subject code is required")
	private String subjectCode;
	
	@NotBlank(message = "Subject name is require")
	private String subjectName;
	
	@NotBlank(message = "Available semester is required")
	@Pattern(regexp = "(Fall|Spring)", message = "Not a valid semester")
	private String availableSemester;

	@Min(value = 1, message = "Minimum credit value is 1")
	private int credit;
	
	private int maxSeats;
	
	private int minSeats;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getAvailableSemester() {
		return availableSemester;
	}

	public void setAvailableSemester(String availableSemester) {
		this.availableSemester = availableSemester;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public int getMinSeats() {
		return minSeats;
	}

	public void setMinSeats(int minSeats) {
		this.minSeats = minSeats;
	}
}
