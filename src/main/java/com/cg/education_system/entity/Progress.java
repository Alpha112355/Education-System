package com.cg.education_system.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Progress implements Serializable{
	
	private static final long serialVersionUID = 613711019933655290L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="PROGRESS_ID")
	private long id;

	@Column(name = "SCORED_MARKS", nullable = false)
	private int ScoredMarks;
	private String Comments;
	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name ="ROLL_ID")
//	private Student student;
	
	
	
	

}
