package com.cg.education_system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable{
	
	private static final long serialVersionUID = 4615262348304629149L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private long AddressId;
	private String Street;
	private String City;
	private String State;
	private long Pincode;

}
