package com.cg.education_system.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.education_system.Exception.CourseNotFoundExcption;
import com.cg.education_system.Exception.StudentNotFoundExcption;
import com.cg.education_system.Service.CourseService;
import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.ProgressDto;
import com.cg.education_system.entity.Course;
import com.cg.education_system.entity.Progress;
import com.cg.education_system.repository.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService{
	Log LOGGER = LogFactory.getFactory().getLog(CourseService.class);
	
	
	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public List<CourseDto> getAllCourse() {
		
		LOGGER.info("CourseServiceImpl::getAllCourse::Entered");
		List<CourseDto> courses = new ArrayList<>();
		
		List<Course> courseList = courseRepo.findAll();
		courseList.stream().forEach(course -> {
			CourseDto courseDto = new CourseDto();
			courseDto.setId(course.getId());
			courseDto.setCourse(course.getCourse());
			courses.add(courseDto);
		});
		LOGGER.info("CourseServiceImpl::getAllCourse::exited");
		return courses;
	}

	@Override
	public CourseDto getCourse(long id) {
		LOGGER.info("CourseServiceImpl::getCourse::Entered");
		Optional<Course> courseOtp = courseRepo.findById(id);
		CourseDto courseDto = new CourseDto();
		if(courseOtp.isPresent()) {
			Course course = courseOtp.get();
			courseDto.setId(course.getId());
			courseDto.setCourse(course.getCourse());
			
		}
		else{
			throw new CourseNotFoundExcption("Course with id::"+id+" Not found");
		}
		
		LOGGER.info("CourseServiceImpl::getCourse::exited");
		return courseDto;
	}

	@Override
	public CourseDto saveCourse(CourseDto course) {
		LOGGER.info("CourseServiceImpl::saveCourse::entered");
		Course courseEntity = new Course();
		courseEntity.setCourse(course.getCourse());
		//courseEntity.setId(course.getId());
		courseRepo.save(courseEntity);
		course.setId(courseEntity.getId());
		LOGGER.info("CourseServiceImpl::saveCourse::exited");
		return course;
	}

	@Override
	public CourseDto updateCourse(CourseDto course) {
		LOGGER.info("CourseServiceImpl::updateCourse::entered");
		Course courseEntity = new Course();
		courseEntity.setCourse(course.getCourse());
		courseEntity.setId(course.getId());
		courseRepo.save(courseEntity);
		LOGGER.info("CourseServiceImpl::updateCourse::exited");
		return course;
	}

	@Override
	public void deleteCourse(long Id) {
		courseRepo.deleteById(Id);
		
	}

	

	
}
