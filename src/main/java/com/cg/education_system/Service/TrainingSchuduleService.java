package com.cg.education_system.Service;

import java.util.List;

import com.cg.education_system.dto.CourseDto;
//import com.cg.education_system.dto.TrainerDto;
import com.cg.education_system.dto.TrainingSchudleDto;

public interface TrainingSchuduleService {
	List<TrainingSchudleDto> getAllTrainingSchudle();
	TrainingSchudleDto getTrainingSchudle(long id);
	TrainingSchudleDto saveTrainingSchudle(TrainingSchudleDto trainingSchudle);
	TrainingSchudleDto updateTrainingSchudle(TrainingSchudleDto trainingSchudle);
	void deleteTrainingSchudle(long Id);

}
