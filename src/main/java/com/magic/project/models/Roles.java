package com.magic.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.ManyToOne; // Import this

@Entity
public class Roles {
	@Id
	@NotNull(message = "Role is required")
	@Pattern(regexp = "^(Agency Manager|Project Leader|Sub Agency Admin|Sales Partner|Bank Office)$", message = "Invalid role")
	private String roleName;

	private String roleFee;

	@ManyToOne // Establish a many-to-one relationship with Agency
	private Agency agency; // Add this field

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleFee() {
		return roleFee;
	}

	public void setRoleFee(String roleFee) {
		this.roleFee = roleFee;
	}

}
