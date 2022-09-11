package com.cg.education_system.dto;

import java.io.Serializable;

//import com.cg.education_system.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable{

	
	private static final long serialVersionUID = -3077866496779335638L;
	
	private long AddressId;
	private String Street;
	private String City;
	private String State;
	private long Pincode;

}
