package com.magic.project.controller;

import com.magic.project.models.Agency;
import com.magic.project.models.User;
import com.magic.project.models.dto.AgencyDto;
import com.magic.project.models.dto.AgencyUserMapper;
import com.magic.project.services.AgencyService;
import com.magic.project.services.UserService;
import com.magic.project.services.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("management/Agency")
public class AgencyController {
	@Autowired
	AgencyService agencyServ;
	@Autowired
	UserService userServ;
	@Autowired
	WorkerService workServ;

	// Add an Agency
	@PostMapping("/add")
	public ResponseEntity<Agency> addAgency(@Valid @RequestBody AgencyDto AgencyDto) {
		Agency Agency = AgencyUserMapper.mapToAgency(AgencyDto);
		User user = AgencyUserMapper.mapToUser(AgencyDto);
		agencyServ.saveAgency(Agency);
		
		user.setUsername(Agency.getEmail());
		userServ.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(Agency);
	}

	// delete a Agency
	@DeleteMapping("/delete/{agencyId}")
	public ResponseEntity<Agency> deleteAgency(@Valid @PathVariable int agencyId) {
		Agency Agency = agencyServ.deleteAgency(agencyId);
		return ResponseEntity.status(HttpStatus.OK).body(Agency);
	}

	// update a Agency by ID and Put request
	@PutMapping("/update/{agencyId}")
	public ResponseEntity<Agency> updateAgency(@Valid @PathVariable int agencyId,
			@RequestBody @Valid Agency updatedAgency) {
		Agency Agency = agencyServ.updateAgency(updatedAgency, agencyId);
		return ResponseEntity.status(HttpStatus.OK).body(Agency);
	}

	// get list of all Agencies
	@GetMapping("/list")
	public ResponseEntity<List<Agency>> getAllAgency() {
		List<Agency> Agencyies = agencyServ.getAgencyList();
		return ResponseEntity.status(HttpStatus.OK).body(Agencyies);
	}

	@GetMapping("/get/{agencyId}")
	public ResponseEntity<Agency> getAgency(@PathVariable @Valid int agencyId) {
		Agency Agency = agencyServ.getAgency(agencyId);
		return ResponseEntity.status(HttpStatus.OK).body(Agency);
	}

}