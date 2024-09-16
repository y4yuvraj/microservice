package com.yuv.microservicesBasics.usersMicroservice.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull
	@Size(min = 3, max = 20)
	private String firstName;
	@NotNull
	@Size(min = 3, max = 20)
	private String lastName;
	@NotNull
	@Size(min = 8, max = 32, message = "password must be greater than 8 character and smaller than 16 characters")
	private String password;
	@Email
	@NotNull
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
