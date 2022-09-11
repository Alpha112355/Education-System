package com.cg.education_system.Controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.education_system.Service.TrainerSchuduleService;
import com.cg.education_system.Service.TrainingSchuduleService;
import com.cg.education_system.dto.TrainingSchudleDto;

@RestController
@RequestMapping("/sms")
public class TrainingSchuduleController {
	Log LOGGER = LogFactory.getFactory().getLog(TrainingSchuduleController.class);
	@Autowired
	TrainingSchuduleService trainerSchuduleService;
	
	
	@GetMapping("/TrainingSchudle")
	public List<TrainingSchudleDto> getAllTrainingSchudle() {
		LOGGER.info("TrainingSchuduleController::getAllTrainingSchudle::Entered");
		List<TrainingSchudleDto> trainingSchudle = trainerSchuduleService.getAllTrainingSchudle();
		System.out.println(trainingSchudle);
		LOGGER.info("TrainingSchuduleController::getAllTrainingSchudle::Exited");
		return trainingSchudle;
	}
	
	@GetMapping("/TrainingSchudle/{id}")
	public TrainingSchudleDto getTrainingSchudle(@PathVariable("id") Long id) {
		LOGGER.info("TrainingSchuduleController::getTrainingSchudle::Entered");
		TrainingSchudleDto trainingSchudleDto = trainerSchuduleService.getTrainingSchudle(id);
		System.out.println( trainingSchudleDto);
		LOGGER.info("TrainingSchuduleController::getTrainingSchudle::exited");
		return trainingSchudleDto;
		
	}
	@PostMapping("/TrainingSchudle")
	public TrainingSchudleDto saveTrainingSchudle(@RequestBody TrainingSchudleDto trainingSchudle) {
		LOGGER.info("TrainingSchuduleController::saveTrainingSchudle::entered");
		TrainingSchudleDto trainingSchudleDto = trainerSchuduleService.saveTrainingSchudle(trainingSchudle);
		System.out.println("Successfully added " + trainingSchudleDto);
		LOGGER.info("TrainingSchuduleController::saveTrainingSchudle::exited");
		return trainingSchudleDto;
		
	}
	@PutMapping("/TrainingSchudle/{id}")
	public TrainingSchudleDto updateTrainingSchudle(@RequestBody TrainingSchudleDto trainingSchudle) {
		LOGGER.info("TrainingSchuduleController::updateTrainingSchudle::entered");
		TrainingSchudleDto trainingSchudleDto = trainerSchuduleService.updateTrainingSchudle(trainingSchudle);
		System.out.println("Successfully updated " + trainingSchudleDto);
		LOGGER.info("TrainingSchuduleController::updateTrainingSchudle::exited");
		return trainingSchudleDto;
		
	}
	
	@DeleteMapping("/TrainingSchudle/{id}")
	public String deleteTrainingSchudle(@PathVariable("id") Long Id) {
		trainerSchuduleService.deleteTrainingSchudle(Id);
		return "Successfully Deleted Student";
		
	}

}
