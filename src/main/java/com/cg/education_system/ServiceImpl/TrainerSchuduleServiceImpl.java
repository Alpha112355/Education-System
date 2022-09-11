package com.cg.education_system.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.education_system.Exception.StudentNotFoundExcption;
import com.cg.education_system.Exception.TrainingSchudleNotFoundExcption;
//import com.cg.education_system.Service.TrainerSchuduleService;
import com.cg.education_system.Service.TrainingSchuduleService;
import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.TrainingSchudleDto;
import com.cg.education_system.entity.Course;
import com.cg.education_system.entity.TrainingSchudle;
import com.cg.education_system.repository.TrainingSchuduleRepository;


@Service

public class TrainerSchuduleServiceImpl implements TrainingSchuduleService{
	Log LOGGER = LogFactory.getFactory().getLog(TrainingSchuduleService.class);
	@Autowired
	TrainingSchuduleRepository trainingSchuduleRepo;
	
	//@Override
	public List<TrainingSchudleDto> getAllTrainingSchudle() {
		LOGGER.info("TrainerSchuduleServiceImpl::getAllTrainingSchudle::Entered");
		
		List<TrainingSchudleDto> trainingSchudles = new ArrayList<>();
		
		List<TrainingSchudle> trainingSchudlesList = trainingSchuduleRepo.findAll();
		trainingSchudlesList.stream().forEach(trainingSchudle -> {
			TrainingSchudleDto trainingSchudleDto = new TrainingSchudleDto();
			trainingSchudleDto.setId(trainingSchudle.getId());
			trainingSchudleDto.setStartDate(trainingSchudle.getStartDate());
			trainingSchudleDto.setEndDate(trainingSchudle.getEndDate());
			trainingSchudleDto.setTimings(trainingSchudle.getTimings());
			trainingSchudleDto.setTrainer(trainingSchudle.getTrainer());
			trainingSchudleDto.setCourse(trainingSchudle.getCourse());
			
			trainingSchudles.add(trainingSchudleDto);
		});
		LOGGER.info("TrainerSchuduleServiceImpl::getAllTrainingSchudle::Exited");
		
		return trainingSchudles;
	}
	

	@Override
	public TrainingSchudleDto getTrainingSchudle(long id) {
		LOGGER.info("TrainerSchuduleServiceImpl::getTrainingSchudle::Entered");
		Optional<TrainingSchudle> trainingSchuduleOpt = trainingSchuduleRepo.findById(id);
		TrainingSchudleDto trainingSehududleDto=new TrainingSchudleDto();
		if(trainingSchuduleOpt.isPresent()) {
			TrainingSchudle trainingSchudule = trainingSchuduleOpt.get();
			trainingSehududleDto.setId(trainingSchudule.getId());
			trainingSehududleDto.setCourse(trainingSchudule.getCourse());
			trainingSehududleDto.setStartDate(trainingSchudule.getStartDate());
			trainingSehududleDto.setEndDate(trainingSchudule.getEndDate());
			trainingSehududleDto.setTrainer(trainingSchudule.getTrainer());
			trainingSehududleDto.setTimings(trainingSchudule.getTimings());
		}
		else{
			throw new TrainingSchudleNotFoundExcption("TrainingSchudle with id::"+id+" Not found");
		}
		LOGGER.info("TrainerSchuduleServiceImpl::getTrainingSchudle::exited");
		return trainingSehududleDto;
	}

	@Override
	public TrainingSchudleDto saveTrainingSchudle(TrainingSchudleDto trainingSchudle) {
		LOGGER.info("TrainerSchuduleServiceImpl::saveTrainingSchudle::entered");
		TrainingSchudle trainingSchudleEntity = new TrainingSchudle();
		//trainingSchudleEntity.setId(trainingSchudle.getId());
		trainingSchudleEntity.setCourse(trainingSchudle.getCourse());
		trainingSchudleEntity.setStartDate(trainingSchudle.getStartDate());
		trainingSchudleEntity.setEndDate(trainingSchudle.getEndDate());
		trainingSchudleEntity.setTrainer(trainingSchudle.getTrainer());
		trainingSchudleEntity.setTimings(trainingSchudle.getTimings());
		trainingSchuduleRepo.save(trainingSchudleEntity);
		trainingSchudle.setId(trainingSchudleEntity.getId());
		
		LOGGER.info("TrainerSchuduleServiceImpl::saveTrainingSchudle::exited");
		return trainingSchudle;
	}

	@Override
	public TrainingSchudleDto updateTrainingSchudle(TrainingSchudleDto trainingSchudle) {
		LOGGER.info("TrainerSchuduleServiceImpl::updateTrainingSchudle::entered");
		TrainingSchudle trainingSchudleEntity = new TrainingSchudle();
		trainingSchudleEntity.setId(trainingSchudle.getId());
		trainingSchudleEntity.setCourse(trainingSchudle.getCourse());
		trainingSchudleEntity.setStartDate(trainingSchudle.getStartDate());
		trainingSchudleEntity.setEndDate(trainingSchudle.getEndDate());
		trainingSchudleEntity.setTrainer(trainingSchudle.getTrainer());
		trainingSchudleEntity.setTimings(trainingSchudle.getTimings());
		trainingSchuduleRepo.save(trainingSchudleEntity);
		LOGGER.info("TrainerSchuduleServiceImpl::updateTrainingSchudle::exited");
		return trainingSchudle;
	}

	
	@Override
	public void deleteTrainingSchudle(long Id) {
		trainingSchuduleRepo.deleteById(Id);
		
	}

	
	
}
