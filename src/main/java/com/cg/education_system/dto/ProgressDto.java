package com.cg.education_system.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cg.education_system.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressDto implements Serializable {
	
	private static final long serialVersionUID = 6478670975068825856L;
	
	private long id;
	
	
	private int ScoredMarks;
	private String Comments;
	
	
	//private Student student;
	

}
