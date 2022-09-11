package com.cg.education_system.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COURSE")
//String
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {

	
	private static final long serialVersionUID = 7433678210587637513L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
	private long id;
	
	@Column(name = "COURSE_NAME")
	private String course;
	
	
	
		
}
