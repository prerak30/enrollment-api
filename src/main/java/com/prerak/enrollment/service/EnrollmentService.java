package com.prerak.enrollment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prerak.enrollment.dto.EnrollmentDto;
import com.prerak.enrollment.model.StudentEnrollment;
import com.prerak.enrollment.repository.StudentEnrollmentRepository;

@Service
public class EnrollmentService {

	private SubjectService subjectService;
	private StudentService studentService;

	private StudentEnrollmentRepository studentEnrollmentRepository;

	public EnrollmentService(SubjectService subjectService, StudentService studentService,
			StudentEnrollmentRepository studentEnrollmentRepository) {
		this.subjectService = subjectService;
		this.studentService = studentService;
		this.studentEnrollmentRepository = studentEnrollmentRepository;
	}

	public Iterable<StudentEnrollment> enrollStudentToSubjects(EnrollmentDto enrollmentDto) throws Exception {
		int creditEnrolled = subjectService
				.calculateSubjectCredits(getAlreadyEnrolledSubjectCodesForGivenStudent(enrollmentDto));

		if (creditEnrolled >= 20) {
			throw new Exception("Already enrolled maximum allowed(20) credit");
		}
		int totalCredits = creditEnrolled + subjectService.calculateSubjectCredits(enrollmentDto.getSubjectCodes());
		if (totalCredits > 20) {
			throw new Exception("You can only enroll to maximum 20 credits");
		}

		Iterable<StudentEnrollment> studentEnrollmentResponse = studentEnrollmentRepository
				.saveAll(buildStudentEnrollments(enrollmentDto));
		studentService.updateStudentEnrollmentStatus(enrollmentDto.getStudentId(),
				totalCredits >= 10 ? "Full Time" : "Part Time");
		return studentEnrollmentResponse;
	}

	private List<String> getAlreadyEnrolledSubjectCodesForGivenStudent(EnrollmentDto enrollmentDto) throws Exception {
		return studentEnrollmentRepository.findAllForStudentByTerm(enrollmentDto.getCurrentTerm().getSemesterName(),
				enrollmentDto.getCurrentTerm().getAcademicYear(), enrollmentDto.getStudentId());
	}

	private List<StudentEnrollment> buildStudentEnrollments(EnrollmentDto enrollmentDto) throws Exception {
		List<StudentEnrollment> studentEnrollments = new ArrayList<>();
		for (String subjectCode : enrollmentDto.getSubjectCodes()) {
			StudentEnrollment studentEnrollment = new StudentEnrollment();
			studentEnrollment.setStudentId(enrollmentDto.getStudentId());
			studentEnrollment.setAcademicYear(enrollmentDto.getCurrentTerm().getAcademicYear());
			studentEnrollment.setSemesterName(enrollmentDto.getCurrentTerm().getSemesterName());
			studentEnrollment.setSubjectCode(subjectCode);
			studentEnrollments.add(studentEnrollment);
		}
		return studentEnrollments;
	}

}
