package com.cg.education_system.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TrainingSchudleNotFoundExcption extends RuntimeException {
	
	private static final long serialVersionUID = -9024299823525086362L;
	private String message;



}
