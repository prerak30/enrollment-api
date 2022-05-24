package com.prerak.enrollment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	private String subjectCode;
	private String subjectName;
	private String availableSemester;

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
