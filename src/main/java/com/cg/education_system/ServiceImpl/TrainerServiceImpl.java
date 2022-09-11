package com.cg.education_system.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.education_system.Exception.StudentNotFoundExcption;
import com.cg.education_system.Exception.TrainerNotFoundExcption;
//import com.cg.education_system.Service.TrainerSchuduleService;
import com.cg.education_system.Service.TrainerService;
import com.cg.education_system.dto.ProgressDto;
import com.cg.education_system.dto.TrainerDto;
import com.cg.education_system.entity.Progress;
import com.cg.education_system.entity.Trainer;
import com.cg.education_system.repository.TrainerRepository;
@Service
public class TrainerServiceImpl implements TrainerService {
	Log LOGGER = LogFactory.getFactory().getLog(TrainerService.class);
	
	@Autowired
	TrainerRepository trainerRepo;
	
	@Override
	public List<TrainerDto> getAllTrainer() {
		
		LOGGER.info("TrainerServiceImpl::getAllTrainer::Entered");
		List<TrainerDto> trainers = new ArrayList<>();
		
		List<Trainer> trainerList = trainerRepo.findAll();
		trainerList.stream().forEach(trainer -> {
			
			TrainerDto trainerDto = new TrainerDto();
			trainerDto.setId(trainer.getId());
			trainerDto.setFirstName(trainer.getFirstName());
			trainerDto.setLastName(trainer.getLastName());
			trainerDto.setEmail(trainer.getEmail());
			trainerDto.setMobile(trainer.getMobile());
			trainerDto.setCourse(trainer.getCourse());
			trainers.add(trainerDto);
			
		});
		LOGGER.info("TrainerServiceImpl::getAllTrainer::Exited");
		return trainers;
	}


	@Override
	public TrainerDto getTrainer(long id) {
		LOGGER.info("TrainerServiceImpl::getTrainer::Entered");
		Optional<Trainer> trainerOpt = trainerRepo.findById(id);
		TrainerDto trainerDto = new TrainerDto();
		if(trainerOpt.isPresent()) {
			Trainer trainer = trainerOpt.get();
			trainerDto.setId(trainer.getId());
			trainerDto.setFirstName(trainer.getFirstName());
			trainerDto.setLastName(trainer.getLastName());
			trainerDto.setMobile(trainer.getMobile());
			trainerDto.setEmail(trainer.getEmail());
			trainerDto.setCourse(trainer.getCourse());
			//trainer.add(trainerDto);
			
			
		
		}
		else{
			throw new TrainerNotFoundExcption("Trainer with id::"+id+" Not found");
		}
		LOGGER.info("TrainerServiceImpl::getTrainer::exited");
		return trainerDto;
	}

	@Override
	public TrainerDto saveTrainer(TrainerDto trainer) {
		LOGGER.info("TrainerServiceImpl::saveTrainer::entered");
		Trainer trainerEntity = new Trainer();
	//	trainerEntity.setId(trainer.getId());
		trainerEntity.setFirstName(trainer.getFirstName());
		trainerEntity.setLastName(trainer.getLastName());
		trainerEntity.setMobile(trainer.getMobile());
		trainerEntity.setEmail(trainer.getEmail());
		trainerEntity.setCourse(trainer.getCourse());
		
		trainerRepo.save(trainerEntity);
		trainer.setId(trainerEntity.getId());
		
		
		LOGGER.info("TrainerServiceImpl::saveTrainer::exited");
		return trainer;
	}

	@Override
	public TrainerDto updateTrainer(TrainerDto trainer) {
		LOGGER.info("TrainerServiceImpl::updateTrainer::entered");
		Trainer trainerEntity = new Trainer();
		trainerEntity.setId(trainer.getId());
		trainerEntity.setFirstName(trainer.getFirstName());
		trainerEntity.setLastName(trainer.getLastName());
		trainerEntity.setMobile(trainer.getMobile());
		trainerEntity.setEmail(trainer.getEmail());
		trainerEntity.setCourse(trainer.getCourse());
		//trainer.setId(trainerEntity.getId());
		trainerRepo.save(trainerEntity);
		LOGGER.info("TrainerServiceImpl::updateTrainer::exited");
		return trainer;
	}

	@Override
	public void deleteTrainer(long Id) {
		trainerRepo.deleteById(Id);
		
	}

	
}
