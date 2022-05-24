package com.prerak.enrollment.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnrollmentDto {

	@NotNull
	private Integer studentId;

	@NotEmpty(message = "Subject codes are required")
	private List<String> subjectCodes;

	@Valid
	@NotNull(message = "Current Term is required")
	private SemesterDto currentTerm;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public List<String> getSubjectCodes() {
		return subjectCodes;
	}

	public void setSubjectCodes(List<String> subjectCodes) {
		this.subjectCodes = subjectCodes;
	}

	public SemesterDto getCurrentTerm() {
		return currentTerm;
	}

	public void setCurrentTerm(SemesterDto currentTerm) {
		this.currentTerm = currentTerm;
	}

}
