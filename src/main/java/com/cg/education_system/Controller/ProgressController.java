package com.cg.education_system.Controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.education_system.Service.ProgressService;
import com.cg.education_system.dto.ProgressDto;
//import com.cg.education_system.dto.StudentDto;

@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class ProgressController {
	Log LOGGER = LogFactory.getFactory().getLog(ProgressController.class);
	@Autowired
	ProgressService progressService;
	
	@GetMapping("/Progress")
	public List<ProgressDto> getAllProgress(){
		LOGGER.info("progressController::getAllProgress::Entered");
		List<ProgressDto> progress = progressService.getAllProgress();
		System.out.println(progress);
		LOGGER.info("progressController::getAllProgress::Exited");
		return progress;
	}
	
	@GetMapping("/Progress/{id}")
	public ProgressDto getProgress(@PathVariable("id") long id) {
		LOGGER.info("progressController::getProgress::Entered");
		ProgressDto progress = progressService.getProgress(id);
		System.out.println(progress);
		LOGGER.info("progressController::getProgress::exited");
		return progress;
	}
	
	@PostMapping("/Progress")
	public ProgressDto saveProgress(@RequestBody ProgressDto progress) {
		LOGGER.info("progressController::saveProgress::Entered");
		ProgressDto progressDto = progressService.saveProgress(progress);
		System.out.println("Successfully added : "+ progress);
		LOGGER.info("progressController::saveProgress::exited");
		return progressDto;
	}
	
	@PutMapping("/Progress/{id}")
	public ProgressDto updateProgress(@RequestBody ProgressDto progress) {
		LOGGER.info("progressController::updateProgress::Entered");
		ProgressDto progressDto = progressService.updateProgress(progress);
		System.out.println("Successfully updated  :"+ progress);
		LOGGER.info("progressController::updateProgress::exited");
		return progressDto;
	}
	
	@DeleteMapping("/Progress/{id}")
	public String deleteProgress(@PathVariable("id") long Id) {
		 progressService.deleteProgress(Id);
		//System.out.println("Successufully Deleted" + Id);
		return "Successfully Deleted Student";
	}

}
