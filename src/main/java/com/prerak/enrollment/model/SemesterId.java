package com.prerak.enrollment.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SemesterId implements Serializable {

	private static final long serialVersionUID = -5404132858135681914L;

	private String semesterName;
	private int academicYear;

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

}
