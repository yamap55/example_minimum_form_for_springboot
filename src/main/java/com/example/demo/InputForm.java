package com.example.demo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class InputForm {
	@NotEmpty
	@Size(min = 1, max = 50)
	private String name;

	@Size(max = 50)
	private String email;

	@NotEmpty
	@Size(max = 100)
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
