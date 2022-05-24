package com.prerak.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.prerak.enrollment.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
