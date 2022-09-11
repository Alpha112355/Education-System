package com.cg.education_system.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

import com.cg.education_system.Service.StudentService;
import com.cg.education_system.dto.StudentDto;

@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class StudentController {
	Log LOGGER = LogFactory.getFactory().getLog(StudentController.class);
	@Autowired
	StudentService studentService;
	
	@GetMapping("/Student")
	public List<StudentDto> getAllStudents(){
		LOGGER.info("StudentController::getAllStudents::Entered");
		List<StudentDto> student = studentService.getAllStudents();
		System.out.println(student);
		LOGGER.info("StudentController::getAllStudents::Exits");
		return student;
		
	}
	@GetMapping("/Student/{id}")
	public StudentDto getStudent(@PathVariable("id") long id) {
		LOGGER.info("StudentController::getStudent::Entered");
		StudentDto studentDto = studentService.getStudent(id);
		System.out.println(studentDto);
		LOGGER.info("StudentController::getStudent::exited");
		return studentDto;
	}
	
	@Validated
	@PostMapping("/Student")
	public StudentDto saveStudent(@RequestBody @Valid StudentDto student) {
		LOGGER.info("StudentController::saveStudent::Entered");
		StudentDto studentDto = studentService.saveStudent(student);
		System.out.println("Successfully added student "+ student);
		LOGGER.info("StudentController::saveStudent::exited");
		return studentDto;
		
	}
	@PutMapping("/Student/{id}")
	
	public StudentDto updateStudent(@RequestBody StudentDto student) {
		LOGGER.info("StudentController::updateStudent::entered");
		StudentDto studentDto = studentService.updateStudent(student);
		LOGGER.info("StudentController::updateStudent::exited");
		return studentDto;
	}
	
	@DeleteMapping("/Student/{id}")
	public String deleteStudent(@PathVariable("id") long Id) {
		studentService.deleteStudent(Id);
		//System.out.println("Successufully Deleted" + Id);
		return "Successfully Deleted Student";
	}
		

}
