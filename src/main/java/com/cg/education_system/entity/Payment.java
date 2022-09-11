package com.cg.education_system.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor

public class Payment implements Serializable{
	
	private static final long serialVersionUID = -8539587834998900249L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="PAYMENT_ID")
	private long id;
	
	private String Amountpaid;
	private String PaymentDate;
	private String Decription;
	
	

}
