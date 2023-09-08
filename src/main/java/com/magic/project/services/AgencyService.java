package com.magic.project.services;

import com.magic.project.models.Agency;

import javax.validation.Valid;
import java.util.List;

public interface AgencyService {

	void saveAgency(@Valid Agency agency);

	Agency deleteAgency(@Valid int agencyId);

	Agency updateAgency(Agency updatedAgency, @Valid int agencyId);

	List<Agency> getAgencyList();

	Agency getAgency(@Valid int agencyId);

}