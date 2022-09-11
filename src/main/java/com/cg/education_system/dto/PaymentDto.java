package com.cg.education_system.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;

import com.cg.education_system.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto implements Serializable{

	
	private static final long serialVersionUID = 2622487205513899422L;
	
	private long id;
	
	private String Amountpaid;
	
	private String PaymentDate;
	@NotBlank(message = "Decription must not be null or empty")
	private String Decription;
	
	//private Student payment;

}
