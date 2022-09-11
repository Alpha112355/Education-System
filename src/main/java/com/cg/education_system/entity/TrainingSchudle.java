package com.cg.education_system.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainingSchudle implements Serializable{
	
	private static final long serialVersionUID = -6293518620881906098L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="SCHUDULE_ID")
	private long id;
	
	
	//private Long SchuduleId;
	
	@Column(name ="START_DATE")
	private String StartDate;
	
	@Column(name ="END_DATE")
	private String EndDate;
	
	@Column(name ="TIMINGS")
	private String Timings;
	
	//@JsonManagedReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "COURSE_ID")
	private Course course;
	
	//@JsonManagedReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "TRAINER_ID")
	private Trainer trainer;
	

}
