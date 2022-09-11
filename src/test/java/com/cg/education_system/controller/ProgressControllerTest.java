package com.cg.education_system.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//import com.capgemini.sms.dto.StudentDto;
import com.cg.education_system.Controller.ProgressController;
//import com.cg.education_system.Service.PaymentService;
import com.cg.education_system.Service.ProgressService;
import com.cg.education_system.dto.ProgressDto;

@ExtendWith(MockitoExtension.class)
public class ProgressControllerTest {
	
	@InjectMocks
	ProgressController progressController;
	
	@Mock
	ProgressService progressSerivce;
	
	@Test
	void getProgressTest() {
		long id = 1;
		ProgressDto progress = createStudentDtoMockData();
		when(progressSerivce.getProgress(id)).thenReturn(progress);
		ProgressDto studentInfo = progressController.getProgress(id);
		assert(progress.getId() == studentInfo.getId());
	}
	
	@Test
	void saveProgressTest() {
		//long id = 1;
		ProgressDto progress = createStudentDtoMockData();
		when(progressSerivce.saveProgress(progress)).thenReturn(progress);
		ProgressDto studentInfo = progressController.saveProgress(progress);
		assert(progress.getId() == studentInfo.getId());
	}
	
	@Test
	void updateProgressTest() {
		//long id = 1;
		ProgressDto progress = createStudentDtoMockData();
		when(progressSerivce.updateProgress(progress)).thenReturn(progress);
		ProgressDto studentInfo = progressController.updateProgress(progress);
		assert(progress.getId() == studentInfo.getId());
	}
	
	@Test
	void deleteProgressTest() {
		long id = 1;
		String msg = "Successfully Deleted Student";
		doNothing().when(progressSerivce).deleteProgress(id);
		String message = progressController.deleteProgress(id);
		assert(message.equals(msg));
	}
	
	private ProgressDto createStudentDtoMockData(){
		ProgressDto progress =new ProgressDto();
		progress.setId(1);
		progress.setComments("lkjlkjlj");
		progress.setScoredMarks(55);
		//progress.setStudent(null);
		return progress;
		
	}

}
