package com.prerak.enrollment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentEnrollmentDto {

	@NotNull(message = "Student Id is required")
	private Integer studentId;
	
	@NotNull(message = "Academic Year is required")
	private Integer academicYear;
	
	@NotBlank(message = "Subject Code is required")
	private String subjectCode;
	
	@NotBlank(message = "Semester is required")
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
