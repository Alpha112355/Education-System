package com.cg.education_system.dto;

import java.io.Serializable;
import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//import com.capgemini.sms.dto.CourseDto;
//import com.capgemini.sms.dto.StudentDto;
import com.cg.education_system.entity.Address;
import com.cg.education_system.entity.Course;
import com.cg.education_system.entity.Payment;
import com.cg.education_system.entity.Progress;
import com.cg.education_system.entity.TrainingSchudle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Serializable {

	
	private static final long serialVersionUID = -3574058176920280914L;
	
	private long id;
	
//	@Min(1)
//	@Max(120)
//	private long RollId;
	
	@NotBlank(message = "name must not be null or empty")
	private String FirstName;
	@NotBlank(message = "name must not be null or empty")
	private String LastName;
//	
	private long Mobile;
	
	@Email(message = "email must be in web-format abc@xyz.com")
	private String Email;
	
	
	
	private Payment PaymentId;
	private Progress progressId;
	
	
	
	private Address address;
	
	
	private TrainingSchudle schudle;
	

}
