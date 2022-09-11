package com.cg.education_system.Service;

import java.util.List;

import com.cg.education_system.dto.StudentDto;



public interface StudentService {
	
	List<StudentDto> getAllStudents();
	StudentDto getStudent(long id);
	StudentDto saveStudent(StudentDto student);
	StudentDto updateStudent(StudentDto student);
	void deleteStudent(long Id);

}
