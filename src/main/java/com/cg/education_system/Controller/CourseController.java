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

import com.cg.education_system.Service.CourseService;
import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.ProgressDto;

@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class CourseController {
	Log LOGGER = LogFactory.getFactory().getLog(CourseController.class);
	@Autowired
	CourseService courseService;
	
	
	@GetMapping("/Course")
	public List<CourseDto> getAllCourse(){
		LOGGER.info("CourseController::getAllCourse::Entered");
		List<CourseDto> course = courseService.getAllCourse();
		System.out.println(course);
		LOGGER.info("CourseController::getAllCourse::Exited");
		return course;
	}
	
	@GetMapping("/Course/{id}")
	public CourseDto getCourse(@PathVariable("id") long id) {
		LOGGER.info("CourseController::getCourse::Entered");
		CourseDto courseDto = courseService.getCourse(id);
		System.out.println("Successfully added " + courseDto);
		LOGGER.info("CourseController::getCourse::exited");
		return courseDto;
	}
	
	@Validated
	@PostMapping("/Course")
	public CourseDto saveCourse(@RequestBody @Valid CourseDto course) {
		LOGGER.info("CourseController::saveCourse::Entered");
		CourseDto courseDto = courseService.saveCourse(course);
		System.out.println("Successfully added " + course);
		LOGGER.info("CourseController::saveCourse::exited");
		return courseDto;
		
	}
	
	@PutMapping("/Course/{id}")
	public CourseDto updateCourse(@RequestBody CourseDto course) {
		LOGGER.info("CourseController::updateCourse::Entered");
		CourseDto courseDto = courseService.updateCourse(course);
		System.out.println("Successfully added " + course);
		LOGGER.info("CourseController::updateCourse::exited");
		return courseDto;
		
	}
	
	@DeleteMapping("/Course/{id}")
	public String deleteCourse(@PathVariable("id") long id) {
		courseService.deleteCourse(id);
		return "Successfully Deleted Student";
	}

}
