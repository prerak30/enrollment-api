package com.prerak.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.prerak.enrollment.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, String> {

}
