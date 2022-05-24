package com.prerak.enrollment.model;

import java.io.Serializable;

import javax.persistence.Id;

public class StudentEnrollmentId implements Serializable {

	private static final long serialVersionUID = -1607285838691462146L;

	@Id
	private int studentId;

	@Id
	private int academicYear;

	@Id
	private String subjectCode;

	@Id
	private String semesterName;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

}
