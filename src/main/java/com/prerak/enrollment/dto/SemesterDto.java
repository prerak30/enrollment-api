package com.prerak.enrollment.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SemesterDto {

	@NotBlank(message = "Semester name is required")
	@Pattern(regexp = "(Fall|Spring)", message = "Invalid Semester Name. e.g Fall")
	private String semesterName;

	@NotNull(message = "Year is required")
	@Min(value = 2022, message = "Invalid year. e.g 2022")
	private Integer academicYear;

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public Integer getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}

}
