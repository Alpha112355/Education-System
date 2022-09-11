package com.cg.education_system.Service;

import java.util.List;

//import com.cg.education_system.dto.PaymentDto;
import com.cg.education_system.dto.TrainerDto;
import com.cg.education_system.dto.TrainingSchudleDto;

public interface TrainerService {
	List<TrainerDto> getAllTrainer();
	TrainerDto getTrainer(long id);
	TrainerDto saveTrainer(TrainerDto trainer);
	TrainerDto updateTrainer(TrainerDto trainer);
	void deleteTrainer(long Id);
}
