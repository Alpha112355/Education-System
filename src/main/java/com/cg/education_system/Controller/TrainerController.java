package com.cg.education_system.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.education_system.Service.TrainerService;
import com.cg.education_system.dto.TrainerDto;

@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class TrainerController {
	Log LOGGER = LogFactory.getFactory().getLog(TrainerController.class);
	@Autowired
	TrainerService trainerService;
	
	@GetMapping("/Trainer")
	public List<TrainerDto> getAllTrainer(){
		LOGGER.info("TrainerController::getAllTrainer::Entered");
		List<TrainerDto> trainer = trainerService.getAllTrainer();
		System.out.println(trainer);
		LOGGER.info("TrainerController::getAllTrainer::Exited");
		return trainer;
	}
	
	
	@GetMapping("/Trainer/{id}")
	public TrainerDto getTrainer(@PathVariable("id") long id) {
		LOGGER.info("TrainerController::getTrainer::Entered");
		TrainerDto trainerDto = trainerService.getTrainer(id);
		System.out.println(trainerDto);
		LOGGER.info("TrainerController::getTrainer::exited");
		return trainerDto;
	}
	@Validated
	@PostMapping("/Trainer")
	public TrainerDto saveTrainer(@RequestBody @Valid TrainerDto trainer) {
		LOGGER.info("TrainerController::saveTrainer::entered");
		TrainerDto trainerDto = trainerService.saveTrainer(trainer);
		System.out.println("Successfully added Trainer" + trainerDto);
		LOGGER.info("TrainerController::saveTrainer::exited");
		return trainerDto;
	}
	
	@PutMapping("/Trainer/{id}")
	public TrainerDto updateTrainer(@RequestBody TrainerDto trainer) {
		LOGGER.info("TrainerController::updateTrainer::entered");
		TrainerDto trainerDto = trainerService.updateTrainer(trainer);
		System.out.println("Successfully updated Trainer" + trainerDto);
		LOGGER.info("TrainerController::updateTrainer::exited");
		
		return trainerDto;
	}
	
	@DeleteMapping("/Trainer/{id}")
	public String deleteTrainer(@PathVariable("id") Long Id) {
		trainerService.deleteTrainer(Id);
		return "Successfully Deleted Student";
	}

}
