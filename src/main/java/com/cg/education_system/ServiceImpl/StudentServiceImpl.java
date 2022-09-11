package com.cg.education_system.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.education_system.Exception.StudentNotFoundExcption;
//import com.cg.education_system.exception.StudentNotFoundExcption;
import com.cg.education_system.Service.StudentService;
import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.StudentDto;
import com.cg.education_system.entity.Course;
import com.cg.education_system.entity.Student;
//import com.cg.education_system.exceptions.StudentNotFoundExcption;
import com.cg.education_system.repository.CourseRepository;
import com.cg.education_system.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	Log LOGGER = LogFactory.getFactory().getLog(StudentService.class);
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<StudentDto> getAllStudents() {
		LOGGER.info("StudentServiceImpl::getAllStudents::Entered");
		List<StudentDto> students = new ArrayList<>();
		
		List<Student> studentsList = studentRepository.findAll();
		
		studentsList.stream().forEach( student -> {
			
			StudentDto studentDto = new StudentDto();
			studentDto.setId(student.getId());
			studentDto.setEmail(student.getEmail());
			studentDto.setFirstName(student.getFirstName());
			studentDto.setLastName(student.getLastName());
			studentDto.setMobile(student.getMobile());
			//studentDto.setRollId(student.getRollId());
			studentDto.setAddress(student.getAddress());
			studentDto.setPaymentId(student.getPaymentId());
			studentDto.setProgressId(student.getProgressId());
			studentDto.setSchudle(student.getSchudle());
//			
			students.add(studentDto);
		});
		LOGGER.info("StudentServiceImpl::getAllStudents::Exited");
		
		return students;
	}

	@Override
	public StudentDto getStudent(long id) {
		LOGGER.info("StudentServiceImpl::getStudent::Entered");
		Optional<Student> studentOpt = studentRepository.findById(id);
		StudentDto studentDto = new StudentDto();
		if(studentOpt.isPresent()) {
			Student student = studentOpt.get();
			studentDto.setId(student.getId());
			studentDto.setEmail(student.getEmail());
			studentDto.setFirstName(student.getFirstName());
			studentDto.setLastName(student.getLastName());
			studentDto.setMobile(student.getMobile());
		//	studentDto.setRollId(student.getRollId());
			//studentDto.setCourse(student.getCourse());
			studentDto.setAddress(student.getAddress());
			studentDto.setPaymentId(student.getPaymentId());
			studentDto.setProgressId(student.getProgressId());
		}
		else{
			throw new StudentNotFoundExcption("Student with id::"+id+" Not found");
		}
		LOGGER.info("StudentServiceImpl::getStudent::exited");
		return studentDto;
	}

	//@Override
	public StudentDto saveStudent(StudentDto students) {
		LOGGER.info("StudentServiceImpl::saveStudent::Entered");
		Student stduentEntity = new Student();

		//stduentEntity.setId(student.getId());
		stduentEntity.setEmail(students.getEmail());
		stduentEntity.setFirstName(students.getFirstName());
		stduentEntity.setLastName(students.getLastName());
		stduentEntity.setMobile(students.getMobile());
		//stduentEntity.setRollId(students.getRollId());
	//	stduentEntity.setCourse(student.getCourse());
		stduentEntity.setAddress(students.getAddress());
		stduentEntity.setPaymentId(students.getPaymentId());
		stduentEntity.setProgressId(students.getProgressId());
//	
		
		studentRepository.save(stduentEntity);
		
		students.setId(stduentEntity.getId());
		
		LOGGER.info("StudentServiceImpl::saveStudent::exited");
		return students;
		
		
		
	}

	@Override

	public StudentDto updateStudent(StudentDto student) {
		LOGGER.info("StudentServiceImpl::updateStudent::Entered");
		Student stduentEntity = new Student();	
		
		stduentEntity.setId(student.getId());
		stduentEntity.setEmail(student.getEmail());
		stduentEntity.setFirstName(student.getFirstName());
		stduentEntity.setLastName(student.getLastName());
		stduentEntity.setMobile(student.getMobile());
	//	stduentEntity.setRollId(student.getRollId());
		//stduentEntity.setCourse(student.getCourse());
		stduentEntity.setAddress(student.getAddress());
		stduentEntity.setPaymentId(student.getPaymentId());
		stduentEntity.setProgressId(student.getProgressId());
		studentRepository.save(stduentEntity);		
		
		LOGGER.info("StudentServiceImpl::updateStudent::exited");
		
		return student;
	}

	@Override
	public void deleteStudent(long Id) {
		studentRepository.deleteById(Id);
		
	}


}
