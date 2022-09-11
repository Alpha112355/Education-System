package com.cg.education_system.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.cg.education_system.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto implements Serializable {
	
	private static final long serialVersionUID = 889520666535398367L;
	
	private long Id;
	
	//private Long TrainerId;
	
	@NotBlank(message = "name must not be null or empty")
	private String FirstName;
	
	@NotBlank(message = "name must not be null or empty")
	private String LastName;
	

	private long Mobile;
	
	@Email(message = "email must be in web-format abc@xyz.com")
	private String Email;
	
	//private String Subjecthandle;
	
	private Course course;

}
