package com.cg.education_system.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.education_system.Controller.StudentController;
import com.cg.education_system.Service.StudentService;
import com.cg.education_system.dto.StudentDto;

@ExtendWith(MockitoExtension.class)

public class StudentControllerTest {
	
	@InjectMocks
	StudentController studentController;
	
	@Mock
	StudentService studentService;
	
	
	@Test
	void getAllStudentsTest() {
		
		List<StudentDto> students = createStudentsDtoMockData();		
		when(studentService.getAllStudents()).thenReturn(students);
		
		List<StudentDto> studentList = studentController.getAllStudents();
		
		assert(students.size() == studentList.size());
		
	}
	
	
	@Test
	void getStudentTest() {
		
		long id = 1;
		StudentDto student = createStudentDtoMockData();		
		when(studentService.getStudent(id)).thenReturn(student);
		
		StudentDto studentInfo = studentController.getStudent(id);
		
		assert(student.getId() == studentInfo.getId());
		
	}
	
	@Test
	
	void saveStudentTest() {
		StudentDto student = createStudentDtoMockData();
		when(studentService.saveStudent(student)).thenReturn(student);
		StudentDto studentInfo = studentController.saveStudent(student);
		assert(student.getId() == studentInfo.getId());
	}
	
	@Test
	void updateStudentTest() {
	
		StudentDto student = createStudentDtoMockData();	
	
		when(studentService.updateStudent(student)).thenReturn(student);
		
		StudentDto studentInfo = studentController.updateStudent(student);
		
		assert(student.getId() == studentInfo.getId());
		
	}
	
	
	private List<StudentDto> createStudentsDtoMockData(){
		List<StudentDto> students = new ArrayList<>();
		StudentDto student = new StudentDto();
		student.setId(1);
		student.setFirstName("sam");
		student.setLastName("ram");
		student.setAddress(null);
		student.setMobile(165464);
		//student.setRollId(1);
		student.setEmail("sam@ram.com");
		student.setPaymentId(null);
		student.setProgressId(null);
		student.setSchudle(null);
		students.add(student);
		return students;
		
	}
	
	

	private StudentDto createStudentDtoMockData() {
		StudentDto student = new StudentDto();
		student.setId(1);
		student.setFirstName("sam");
		student.setLastName("ram");
		student.setAddress(null);
		student.setMobile(165464);
		//student.setRollId(1);
		student.setEmail("sam@ram.com");
		student.setPaymentId(null);
		student.setProgressId(null);
		student.setSchudle(null);
		return student;
	}

}
