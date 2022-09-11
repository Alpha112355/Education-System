package com.cg.education_system.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.capgemini.sms.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainer implements Serializable{
	
	private static final long serialVersionUID = -1382934017038615679L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAINER_ID")
	private long Id;
	

	
	
	
	private String FirstName;
	private String LastName;
	
	@Column(name = "MOBILE")
	private long Mobile;
	
	@Column(name = "EMAIL")
	private String Email;
	
//	@Column(name = "SUBJECT_HANDLE")
//	private String Subjecthandle;
//	@JsonManagedReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "COURSE_ID")
	private Course course;
	


}
