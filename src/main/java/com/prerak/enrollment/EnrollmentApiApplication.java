package com.prerak.enrollment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnrollmentApiApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/enrollment");
		SpringApplication.run(EnrollmentApiApplication.class, args);
	}

}
