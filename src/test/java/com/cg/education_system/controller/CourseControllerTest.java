package com.cg.education_system.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.education_system.Controller.CourseController;
import com.cg.education_system.Service.CourseService;
import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.PaymentDto;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
	@InjectMocks
	CourseController courseController;
	
	@Mock
	CourseService courseService;
	
	@Test
	void getCourseTest() {
		long id = 1;
		CourseDto course = createStudentDtoMockData();
		when(courseService.getCourse(id)).thenReturn(course);
		CourseDto studentInfo = courseController.getCourse(id);
		assert(course.getId() == studentInfo.getId());
	}
	
	
	@Test
	void updateCourseTest() {
		//long id = 1;
		CourseDto course = createStudentDtoMockData();
		when(courseService.updateCourse(course)).thenReturn(course);
		CourseDto studentInfo = courseController.updateCourse(course);
		assert(course.getId() == studentInfo.getId());
	}
	
	
	
	@Test
	void saveCourseTest() {
		//long id = 1;
		CourseDto course = createStudentDtoMockData();
		when(courseService.saveCourse(course)).thenReturn(course);
		CourseDto studentInfo = courseController.saveCourse(course);
		assert(course.getId() == studentInfo.getId());
	}
	
	@Test
	void deleteCourseTest() {
		long id = 1;
		String msg = "Successfully Deleted Student";
		doNothing().when(courseService).deleteCourse(id);
		String message = courseController.deleteCourse(id);
		assert(message.equals(msg));
	}
	
	
	private CourseDto createStudentDtoMockData(){
		CourseDto course = new CourseDto();
		course.setId(1);
		course.setCourse("java");
		return course;
	}

}
