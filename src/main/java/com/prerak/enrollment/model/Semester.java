package com.prerak.enrollment.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Semester {

	@EmbeddedId
	private SemesterId semesterId;

	public SemesterId getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(SemesterId semesterId) {
		this.semesterId = semesterId;
	}

}
