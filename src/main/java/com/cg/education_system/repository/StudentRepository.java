package com.cg.education_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.education_system.dto.StudentDto;
import com.cg.education_system.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	//Object save(StudentDto students);

	//public void save(Student students);

	//public void saveStudents(Student student);
	//Optional<Student> findByName(String name);
}
