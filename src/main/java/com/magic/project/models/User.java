package com.magic.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="User_Details")
public class User {
	@Id
	@NotBlank(message = "Username is required")
	@Email(message = "Email ")
	private String username;

	@NotBlank(message = "Password is required")
	@Column(length = 200)
	private String password;

	@NotBlank(message = "Role is required")
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
