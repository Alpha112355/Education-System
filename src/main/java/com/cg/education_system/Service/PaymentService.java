package com.cg.education_system.Service;

import java.util.List;

import com.cg.education_system.dto.PaymentDto;
//import com.cg.education_system.dto.ProgressDto;
import com.cg.education_system.dto.ProgressDto;

public interface PaymentService {
	List<PaymentDto> getAllPayment();
	PaymentDto getPayment(long id);
	PaymentDto savePayment(PaymentDto payment);
	PaymentDto updatePayment(PaymentDto payment);
	void deletePayment(long Id);

}
