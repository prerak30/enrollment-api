
package com.prerak.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.prerak.enrollment.model.Semester;
import com.prerak.enrollment.model.SemesterId;

public interface SemesterRepository extends CrudRepository<Semester, SemesterId> {

}
