package com.prerak.enrollment.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto {

	@NotEmpty(message = "Username is required")
	private String username;

	@NotEmpty(message = "User type is required")
	@Pattern(regexp = "(Admin|Student)", message = "Not a valid User type")
	private String userType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
