package com.magic.project.models;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Worker {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_sequence_generator")
    @SequenceGenerator(name = "worker_sequence_generator", sequenceName = "worker_sequence_generator", allocationSize = 100)
    private int workerId;

	@NotBlank(message = "First name is required")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Only alphabets are allowed for first name")
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Only alphabets are allowed for last name")
	private String lastName;
	
	@NotNull(message = "Role is required")
	@Pattern(regexp = "^(Agency Manager|Project Leader|Sub Agency Admin|Sales Partner|Bank Office)$", message = "Invalid role")
	private String role;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number should contain exactly 10 digits")
	private String phoneNo;
	
	@NotNull(message = "Status is required")
	private String status;
	
	@Pattern(regexp = "^[0-9]+$")
	private String fees;
	
	@NotNull(message = "Date is required")
	private Date startDate;

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	

}
