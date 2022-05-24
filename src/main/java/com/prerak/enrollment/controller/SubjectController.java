package com.prerak.enrollment.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prerak.enrollment.dto.EnrollmentDto;
import com.prerak.enrollment.dto.SubjectDto;
import com.prerak.enrollment.model.StudentEnrollment;
import com.prerak.enrollment.service.EnrollmentService;
import com.prerak.enrollment.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	/*
	 * add subject Get the full history of classes enrolled
	 */
	private SubjectService subjectService;
	private EnrollmentService enrollmentService;

	public SubjectController(SubjectService subjectService, EnrollmentService enrollmentService) {
		this.subjectService = subjectService;
		this.enrollmentService = enrollmentService;
	}

	@PostMapping
	public ResponseEntity<SubjectDto> addSubject(@RequestBody @Valid SubjectDto subjectDto) throws Exception {
		return new ResponseEntity<>(subjectService.addSubject(subjectDto), HttpStatus.CREATED);
	}

	@PatchMapping("/{code}")
	public ResponseEntity<SubjectDto> updateSubject(@PathVariable(value = "code") @NotBlank String subjectCode,
			@Valid @RequestBody SubjectDto subjectDto) throws Exception {
		return new ResponseEntity<>(subjectService.updateSubject(subjectCode, subjectDto), HttpStatus.OK);
	}

	@PostMapping("/enroll")
	public ResponseEntity<Iterable<StudentEnrollment>> enrollStudentToSubjects(
			@RequestBody @Valid EnrollmentDto enrollmentDto) throws Exception {
		return new ResponseEntity<>(enrollmentService.enrollStudentToSubjects(enrollmentDto), HttpStatus.CREATED);
	}

	// @PutMapping("/enroll")

}
