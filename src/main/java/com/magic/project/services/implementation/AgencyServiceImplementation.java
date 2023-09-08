package com.magic.project.services.implementation;

import com.magic.project.handler.AgencyNotFoundException;
import com.magic.project.models.Agency;
import com.magic.project.repositories.AgencyRepository;
import com.magic.project.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class AgencyServiceImplementation implements AgencyService {
	@Autowired
	AgencyRepository agencyRepo;

	@Override
	public void saveAgency(@Valid Agency agency) {
		agencyRepo.save(agency);
	}

	@Override
	public Agency deleteAgency(@Valid int agencyId) {
		Agency agency = agencyRepo.findById(agencyId).orElse(null);
		if (agency == null) {
			throw new AgencyNotFoundException("No Agency found with ID " + agencyId);
		}
		agencyRepo.deleteById(agencyId);
		return agency;
	}

	@Override
	public Agency updateAgency(@Valid Agency updatedAgency, @Valid int agencyId) {
		Agency agency = agencyRepo.findById(agencyId).orElse(null);
		if (agency == null) {
			throw new AgencyNotFoundException("No Agency found with ID " + agencyId);
		}
		updatedAgency.setAgencyId(agencyId);
		agencyRepo.save(updatedAgency);
		return updatedAgency;
	}

	@Override
	public List<Agency> getAgencyList() {
		List<Agency> agencies = agencyRepo.findAll();
		if (agencies.isEmpty()) {
			throw new AgencyNotFoundException("No Agency found.");
		}
		return agencies;
	}

	@Override
	public Agency getAgency(@Valid int agencyId) {
		Agency agency = agencyRepo.findById(agencyId).orElse(null);
		if (agency == null) {
			throw new AgencyNotFoundException("No Agency found with ID " + agencyId);
		}
		return agency;
	}

}