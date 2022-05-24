package com.prerak.enrollment.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.prerak.enrollment.dto.StudentDto;
import com.prerak.enrollment.model.Student;
import com.prerak.enrollment.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	private ModelMapper modelMapper;

	public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}

	public StudentDto getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentDto getStudentById(int studentId) throws Exception {
		return mapStudentEntityToDto(getStudentForGivenId(studentId));
	}

	public StudentDto addStudent(StudentDto studentDto) throws Exception {
		return mapStudentEntityToDto(studentRepository.save(mapStudentDtoToEntity(studentDto)));
	}

	public StudentDto updateStudent(int studentId, StudentDto studentDto) throws Exception {
		getStudentForGivenId(studentId);
		Student student = mapStudentDtoToEntity(studentDto);
		student.setStudentId(studentId);
		return mapStudentEntityToDto(studentRepository.save(student));
	}

	public void updateStudentEnrollmentStatus(Integer studentId, String enrollmentStatus) throws Exception {
		Student student = getStudentForGivenId(studentId);
		student.setEnrollmentStatus(enrollmentStatus);
		studentRepository.save(student);
	}

	private Student mapStudentDtoToEntity(StudentDto studentDto) throws Exception {
		return modelMapper.map(studentDto, Student.class);
	}

	private StudentDto mapStudentEntityToDto(Student student) throws Exception {
		return modelMapper.map(student, StudentDto.class);
	}

	private Student getStudentForGivenId(int studentId) throws Exception {
		Optional<Student> existingStudent = studentRepository.findById(studentId);
		if (existingStudent.isEmpty()) {
			throw new Exception("Student record is not present");
		}
		return existingStudent.get();
	}

}
