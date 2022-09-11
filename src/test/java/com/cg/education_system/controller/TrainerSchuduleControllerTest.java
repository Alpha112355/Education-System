package com.cg.education_system.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.education_system.Controller.TrainingSchuduleController;
//import com.cg.education_system.Service.TrainerSchuduleService;
import com.cg.education_system.Service.TrainingSchuduleService;
import com.cg.education_system.dto.TrainerDto;
//import com.cg.education_system.dto.TrainerDto;
import com.cg.education_system.dto.TrainingSchudleDto;

@ExtendWith(MockitoExtension.class)
public class TrainerSchuduleControllerTest {
	
	@InjectMocks
	TrainingSchuduleController trainingSchuduleController;
	
	@Mock
	TrainingSchuduleService trainerSchuduleService;
	
	
	@Test
	void getTrainingSchudleTest() {
		long id = 1;
		TrainingSchudleDto trainerSchudle = createStudentDtoMockData();
		when(trainerSchuduleService.getTrainingSchudle(id)).thenReturn(trainerSchudle);
		TrainingSchudleDto studentInfo = trainingSchuduleController.getTrainingSchudle(id);
		assert(trainerSchudle.getId() == studentInfo.getId());
	}
	
	@Test
	void saveTrainingSchudleTest() {
		//long id = 1;
		TrainingSchudleDto trainerSchudle = createStudentDtoMockData();
		when(trainerSchuduleService.saveTrainingSchudle(trainerSchudle)).thenReturn(trainerSchudle);
		TrainingSchudleDto studentInfo = trainingSchuduleController.saveTrainingSchudle(trainerSchudle);
		assert(trainerSchudle.getId() == studentInfo.getId());
	}
	
	@Test
	void updateTrainingSchudleTest() {
		//long id = 1;
		TrainingSchudleDto trainerSchudle = createStudentDtoMockData();
		when(trainerSchuduleService.updateTrainingSchudle(trainerSchudle)).thenReturn(trainerSchudle);
		TrainingSchudleDto studentInfo = trainingSchuduleController.updateTrainingSchudle(trainerSchudle);
		assert(trainerSchudle.getId() == studentInfo.getId());
	}
	
	@Test
	void deleteTrainingSchudleTest() {
		long id = 1;
		String msg = "Successfully Deleted Student";
		doNothing().when(trainerSchuduleService).deleteTrainingSchudle(id);
		String message = trainingSchuduleController.deleteTrainingSchudle(id);
		assert(message.equals(msg));
	}
	
	
	
	private TrainingSchudleDto createStudentDtoMockData(){
		TrainingSchudleDto trainingSchudle = new TrainingSchudleDto();
		trainingSchudle.setId(1);
		trainingSchudle.setCourse(null);
		trainingSchudle.setTimings("2hours");
		trainingSchudle.setStartDate("2/2/2222");
		trainingSchudle.setEndDate("3/3/3333");
		trainingSchudle.setTrainer(null);
		return trainingSchudle;
		
	}
	

}
