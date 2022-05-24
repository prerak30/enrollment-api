package com.prerak.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.prerak.enrollment.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
