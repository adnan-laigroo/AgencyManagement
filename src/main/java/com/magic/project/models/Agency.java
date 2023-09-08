package com.magic.project.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Agency {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_sequence_generator")
    @SequenceGenerator(name = "agency_sequence_generator", sequenceName = "agency_sequence_generator", allocationSize = 1)
    private int agencyId;

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
	
	@ElementCollection
	private List<String> activeBranches;

	@Pattern(regexp = "^\\d+ months$")
	private String contractDuration; 
	
	@Pattern(regexp = "^[0-9]+$")
	private String numberOfWorkers;



	
	@OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
	private List<Roles> roles;
	
	@ElementCollection
	private	List<Integer> listWorkersIds;

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

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

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public List<Integer> getListWorkersIds() {
		return listWorkersIds;
	}

	public void setListWorkersIds(List<Integer> listWorkersIds) {
		this.listWorkersIds = listWorkersIds;
	}


	
}
