package com.cg.education_system.Service;

import java.util.List;

import com.cg.education_system.dto.CourseDto;
//import com.cg.education_system.dto.PaymentDto;

//import com.capgemini.sms.dto.StudentDto;

public interface CourseService {
	List<CourseDto> getAllCourse();
	CourseDto getCourse(long id);
	//CourseDto getCourse(CourseDto course);
	CourseDto saveCourse(CourseDto course);
	CourseDto updateCourse(CourseDto course);
	void deleteCourse(long Id);

}
