package com.cg.education_system.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.education_system.Controller.TrainerController;
import com.cg.education_system.Service.TrainerService;
import com.cg.education_system.dto.PaymentDto;
import com.cg.education_system.dto.TrainerDto;

@ExtendWith(MockitoExtension.class)
public class TrainerControllerTest {
	
	@InjectMocks
	TrainerController trainerController;
	
	@Mock
	TrainerService trainerService;
	
	
	@Test
	void getTrainerTest() {
		long id = 1;
		TrainerDto trainer = createStudentDtoMockData();
		when(trainerService.getTrainer(id)).thenReturn(trainer);
		TrainerDto studentInfo = trainerController.getTrainer(id);
		assert(trainer.getId() == studentInfo.getId());
	}
	
	
	@Test
	void saveTrainerTest() {
		//long id = 1;
		TrainerDto trainer = createStudentDtoMockData();
		when(trainerService.saveTrainer(trainer)).thenReturn(trainer);
		TrainerDto studentInfo = trainerController.saveTrainer(trainer);
		assert(trainer.getId() == studentInfo.getId());
	}
	
	
	@Test
	void updateTrainerTest() {
		//long id = 1;
		TrainerDto trainer = createStudentDtoMockData();
		when(trainerService.updateTrainer(trainer)).thenReturn(trainer);
		TrainerDto studentInfo = trainerController.updateTrainer(trainer);
		assert(trainer.getId() == studentInfo.getId());
	}
	
	
	@Test
	void deleteTrainerTest() {
		long id = 1;
		String msg = "Successfully Deleted Student";
		doNothing().when(trainerService).deleteTrainer(id);
		String message = trainerController.deleteTrainer(id);
		assert(message.equals(msg));
	}
	
	
	private TrainerDto createStudentDtoMockData(){
		TrainerDto trainer = new TrainerDto();
		trainer.setId(1);
		trainer.setFirstName("sam");
		trainer.setLastName("ram");
		trainer.setEmail("trainer@cg.com");
		trainer.setMobile(13264897);
		trainer.setCourse(null);
		return trainer;
	}
	

}
