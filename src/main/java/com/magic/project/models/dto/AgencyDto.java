package com.magic.project.models.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.magic.project.models.Roles;
import com.magic.project.models.Worker;

public class AgencyDto {

	@NotNull
	private String companyName;

	@NotNull	
	private String streetHouseNr;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Only alphabets are allowed")
	private String pcCity;
	
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number should contain exactly 10 digits")
	private String phoneNo;
	
	@Email
	private String email;
	
	
	private List<String> activeBranches;

	@Pattern(regexp = "^\\d+ months$")
	private String contractDuration; 
	
	@Pattern(regexp = "^[0-9]+$")
	private String numberOfWorkers;
	
	private List<Roles> roles;
	
	private String role;
	
	@OneToMany
	private	List<Worker> listWorkers;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$", message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character")
	private String password;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreetHouseNr() {
		return streetHouseNr;
	}

	public void setStreetHouseNr(String streetHouseNr) {
		this.streetHouseNr = streetHouseNr;
	}

	public String getPcCity() {
		return pcCity;
	}

	public void setPcCity(String pcCity) {
		this.pcCity = pcCity;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getActiveBranches() {
		return activeBranches;
	}

	public void setActiveBranches(List<String> activeBranches) {
		this.activeBranches = activeBranches;
	}

	public String getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(String contractDuration) {
		this.contractDuration = contractDuration;
	}

	public String getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(String numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> role) {
		this.roles = role;
	}

	public List<Worker> getListWorkers() {
		return listWorkers;
	}

	public void setListWorkers(List<Worker> listWorkers) {
		this.listWorkers = listWorkers;
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
