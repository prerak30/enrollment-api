package com.prerak.enrollment.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prerak.enrollment.dto.CredentialDto;
import com.prerak.enrollment.dto.UserDto;
import com.prerak.enrollment.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	/*
	 * add user update user admin can update usertype
	 */

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public String addUser(@Valid @RequestBody UserDto userDto) throws Exception {
		return userService.addUser(userDto);
	}

	@PostMapping("/signup")
	public String signupUser(@RequestBody CredentialDto credentialDto) throws Exception {
		return userService.signupUser(credentialDto);
	}
}
