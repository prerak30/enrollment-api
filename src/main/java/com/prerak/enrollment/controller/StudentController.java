package com.prerak.enrollment.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prerak.enrollment.dto.StudentDto;
import com.prerak.enrollment.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	/*
	 * add student update student Get the list of classes for a particular student
	 * for a semester Get the full history of classes enrolled
	 */

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("id") @NotNull Integer studentId) throws Exception {
		return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<StudentDto> addStudent(@Valid @RequestBody StudentDto studentDto) throws Exception {
		return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") @NotNull Integer studentId,
			@RequestBody StudentDto studentDto) throws Exception {
		return new ResponseEntity<>(studentService.updateStudent(studentId, studentDto), HttpStatus.OK);
	}

}
