package com.cg.education_system.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

//import javax.persistence.Column;

import com.cg.education_system.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable {
	
	private static final long serialVersionUID = -1916888356992814539L;
	
	private long id;
	
	//private Long studentId;
	
	@NotBlank(message = "course must not be null or empty")
	private String course;

}
