package com.cg.education_system.entity;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "STUDENT_INFO")
public class Student implements Serializable{
	
	private static final long serialVersionUID = -6708141826153087140L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Roll_ID")
	private long id;
	
//	@Column(name = "Roll_ID")
//	private long RollId;
	
	private String FirstName;
	private String LastName;
	
	@Column(name = "MOBILE")
	private long Mobile;
	
	@Column(name = "EMAIL")
	private String Email;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "PROGRESS_ID")
	private Progress ProgressId;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "PAYMENT_ID")
	private Payment PaymentId;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "SCHUDULE_ID")
	private TrainingSchudle schudle;
	
	
	
	

}
