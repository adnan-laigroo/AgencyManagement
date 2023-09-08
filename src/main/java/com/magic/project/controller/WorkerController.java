package com.magic.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.project.models.Worker;
import com.magic.project.services.UserService;
import com.magic.project.services.WorkerService;

@RestController
@RequestMapping("management/Worker")
public class WorkerController {
	@Autowired
	UserService userServ;
	@Autowired
	WorkerService workerServ;
	

	// Add an Worker
	@PostMapping("/add/{agencyId}")
	public ResponseEntity<Worker> addWorker(@Valid @RequestBody Worker Worker, @PathVariable int agencyId) {
		
		workerServ.saveWorker(Worker);
		workerServ.setWorkersToAgency(Worker, agencyId);

		return ResponseEntity.status(HttpStatus.OK).body(Worker);
	}

	// delete a Worker
	@DeleteMapping("/delete/{WorkerId}")
	public ResponseEntity<Worker> deleteWorker(@Valid @PathVariable int WorkerId) {
		Worker Worker = workerServ.deleteWorker(WorkerId);
		return ResponseEntity.status(HttpStatus.OK).body(Worker);
	}

	// update a Worker by ID and Put request
	@PutMapping("/update/{WorkerId}")
	public ResponseEntity<Worker> updateWorker(@Valid @PathVariable int WorkerId,
			@RequestBody @Valid Worker updatedWorker) {
		Worker Worker = workerServ.updateWorker(updatedWorker, WorkerId);
		return ResponseEntity.status(HttpStatus.OK).body(Worker);
	}

	// get list of all Agencies
	@GetMapping("/list")
	public ResponseEntity<List<Worker>> getAllWorker() {
		List<Worker> Workeries = workerServ.getWorkerList();
		return ResponseEntity.status(HttpStatus.OK).body(Workeries);
	}

	@GetMapping("/get/{WorkerId}")
	public ResponseEntity<Worker> getWorker(@PathVariable @Valid int WorkerId) {
		Worker Worker = workerServ.getWorker(WorkerId);
		return ResponseEntity.status(HttpStatus.OK).body(Worker);
	}

}
