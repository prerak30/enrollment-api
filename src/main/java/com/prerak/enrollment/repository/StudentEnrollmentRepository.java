package com.prerak.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prerak.enrollment.model.StudentEnrollment;
import com.prerak.enrollment.model.StudentEnrollmentId;

public interface StudentEnrollmentRepository extends CrudRepository<StudentEnrollment, StudentEnrollmentId> {

	@Query("SELECT se.subjectCode FROM StudentEnrollment se WHERE se.semesterName = :semesterName and se.academicYear = :academicYear and se.studentId = :studentId")
	List<String> findAllForStudentByTerm(@Param("semesterName") String semesterName,
			@Param("academicYear") Integer academicYear, @Param("studentId") Integer studentId);
}
