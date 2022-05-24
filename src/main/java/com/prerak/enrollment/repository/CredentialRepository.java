package com.prerak.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.prerak.enrollment.model.Credential;

public interface CredentialRepository extends CrudRepository<Credential, String> {

}
