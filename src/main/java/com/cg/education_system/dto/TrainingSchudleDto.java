package com.cg.education_system.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cg.education_system.entity.Course;
import com.cg.education_system.entity.Trainer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingSchudleDto implements Serializable {
	
	private static final long serialVersionUID = -4386149363285751053L;
	
	private long id;
	
	
	//private Long SchuduleId;
	
	
	private String StartDate;
	
	
	private String EndDate;
	
	
	private String Timings;
	
	
	private Course course;
	
	
	private Trainer trainer;

}
