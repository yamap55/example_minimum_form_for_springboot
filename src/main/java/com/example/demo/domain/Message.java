package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.InputForm;

@Entity
@Table(name="message")
public class Message {
	public Message(InputForm form) {
		this.message = form.getMessage();
		this.email = form.getEmail();
		this.name = form.getName();
	}
	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
