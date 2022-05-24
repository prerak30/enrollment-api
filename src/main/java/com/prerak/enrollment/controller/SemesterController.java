package com.prerak.enrollment.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prerak.enrollment.dto.SemesterDto;
import com.prerak.enrollment.service.SemesterService;

@RestController
public class SemesterController {

	private SemesterService semesterService;

	public SemesterController(SemesterService semesterService) {
		this.semesterService = semesterService;
	}

	@PostMapping("/semester")
	public ResponseEntity<SemesterDto> addSemester(@RequestBody @Valid SemesterDto semesterDto) throws Exception {
		return new ResponseEntity<>(semesterService.addSemester(semesterDto), HttpStatus.OK);
	}
}
