package com.prerak.enrollment.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.prerak.enrollment.dto.CredentialDto;
import com.prerak.enrollment.dto.UserDto;
import com.prerak.enrollment.model.Credential;
import com.prerak.enrollment.model.User;
import com.prerak.enrollment.repository.CredentialRepository;
import com.prerak.enrollment.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private CredentialRepository credentialRepository;
	private ModelMapper modelMapper;

	public UserService(UserRepository userRepository, CredentialRepository credentialRepository,
			ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.credentialRepository = credentialRepository;
		this.modelMapper = modelMapper;
	}

	public String addUser(UserDto userDto) throws Exception {
		userRepository.save(modelMapper.map(userDto, User.class));
		return "success";
	}

	public String signupUser(CredentialDto credentialDto) throws Exception {
		credentialRepository.save(modelMapper.map(credentialDto, Credential.class));
		return "success";
	}

}
