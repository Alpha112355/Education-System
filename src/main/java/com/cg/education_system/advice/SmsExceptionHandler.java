package com.cg.education_system.advice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.education_system.Exception.CourseNotFoundExcption;
import com.cg.education_system.Exception.PaymentNotFoundExcption;
import com.cg.education_system.Exception.ProgressNotFoundExcption;
//
//import com.cg.education_system.Exception.PaymentNotFoundExcption;
//import com.cg.education_system.Exception.ProgressNotFoundExcption;
import com.cg.education_system.Exception.StudentNotFoundExcption;
import com.cg.education_system.Exception.TrainerNotFoundExcption;
import com.cg.education_system.Exception.TrainingSchudleNotFoundExcption;
import com.cg.education_system.entity.Progress;

@RestControllerAdvice
public class SmsExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleBadRequest(MethodArgumentNotValidException ex){
		Map<String, String> erros = new LinkedHashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			erros.put(error.getField(), error.getDefaultMessage());
		});
		
		return erros;		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StudentNotFoundExcption.class)
	public String notFoundHandlaer(StudentNotFoundExcption ex){
		return ex.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProgressNotFoundExcption.class)
	public String notFoundHandlaer(ProgressNotFoundExcption ex){
		return ex.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PaymentNotFoundExcption.class)
	public String notFoundHandlaer(PaymentNotFoundExcption ex){
		return ex.getMessage();
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CourseNotFoundExcption.class)
	public String notFoundHandlaer(CourseNotFoundExcption ex){
		return ex.getMessage();
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TrainingSchudleNotFoundExcption.class)
	public String notFoundHandlaer(TrainingSchudleNotFoundExcption ex){
		return ex.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TrainerNotFoundExcption.class)
	public String notFoundHandlaer(TrainerNotFoundExcption ex){
		return ex.getMessage();
	}
	
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String internalServerError(Exception ex){
		return ex.getMessage();
	}

}
