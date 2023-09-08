package com.magic.project.services.implementation;

import com.magic.project.handler.WorkerNotFoundException;
import com.magic.project.models.Agency;
import com.magic.project.models.Worker;
import com.magic.project.repositories.AgencyRepository;
import com.magic.project.repositories.WorkerRepository;
import com.magic.project.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class WorkerServiceImplementation implements WorkerService {
	@Autowired
	WorkerRepository workerRepo;
	@Autowired
	AgencyRepository agencyRepo;
	

	@Override
	public void saveWorker(@Valid Worker Worker) {
		workerRepo.save(Worker);

	}

	@Override
	public void setWorkersToAgency(@Valid Worker Worker, int agencyId) {
		Agency agency = agencyRepo.findById(agencyId).orElse(null);
		List<Integer> listWorkers =  agency.getListWorkersIds();
		listWorkers.add(Worker.getWorkerId());
		agency.setListWorkersIds(listWorkers);
		agencyRepo.save(agency);

	}
	@Override
	public Worker deleteWorker(@Valid int workerId) {
		Worker Worker = workerRepo.findById(workerId).orElse(null);
		if (Worker == null) {
			throw new WorkerNotFoundException("No Worker with ID " + workerId);
		}
		workerRepo.deleteById(workerId);
		return Worker;
	}

	@Override
	public Worker updateWorker(Worker updatedWorker, @Valid int workerId) {
		Worker Worker = workerRepo.findById(workerId).orElse(null);
		if (Worker == null) {
			throw new WorkerNotFoundException("No Worker with ID " + workerId);
		}
		updatedWorker.setWorkerId(workerId);
		workerRepo.save(updatedWorker);
		return updatedWorker;
	}

	@Override
	public List<Worker> getWorkerList() {
		List<Worker> Workers = workerRepo.findAll();
		if (Workers == null) {
			throw new WorkerNotFoundException("No Worker Found.");
		}
		return Workers;
	}

	@Override
	public Worker getWorker(@Valid int workerId) {
		Worker Worker = workerRepo.findById(workerId).orElse(null);
		if (Worker == null) {
			throw new WorkerNotFoundException("No Worker with ID " + workerId);
		}
		return Worker;
	}

}