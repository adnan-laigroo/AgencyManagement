package com.magic.project.services;

import com.magic.project.models.Worker;

import javax.validation.Valid;
import java.util.List;

public interface WorkerService {

	void saveWorker(@Valid Worker Worker);

	void setWorkersToAgency(@Valid Worker Worker, int agencyId);
	
	Worker deleteWorker(@Valid int workerId);

	Worker updateWorker(Worker updatedWorker, @Valid int workerId);

	List<Worker> getWorkerList();

	Worker getWorker(@Valid int workerId);

}