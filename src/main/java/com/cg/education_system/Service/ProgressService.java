package com.cg.education_system.Service;

import java.util.List;

//import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.ProgressDto;
//import com.cg.education_system.dto.StudentDto;

public interface ProgressService {
	
	List<ProgressDto> getAllProgress();
	ProgressDto getProgress(long id);
	ProgressDto saveProgress(ProgressDto progress);
	ProgressDto updateProgress(ProgressDto progress);
	void deleteProgress(long Id);

}
