package com.cg.education_system.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.education_system.Controller.PaymentController;
import com.cg.education_system.Service.PaymentService;
import com.cg.education_system.dto.PaymentDto;
//import com.cg.education_system.dto.ProgressDto;
import com.cg.education_system.dto.ProgressDto;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {
	
	@InjectMocks
	PaymentController paymentController;
	
	@Mock
	PaymentService paymentService;
	
	@Test
	void getPaymentTest() {
		long id = 1;
		PaymentDto payment = createStudentDtoMockData();
		when(paymentService.getPayment(id)).thenReturn(payment);
		PaymentDto studentInfo = paymentController.getPayment(id);
		assert(payment.getId() == studentInfo.getId());
	}
	
	@Test
	void savePaymentTest() {
		//long id = 1;
		PaymentDto payment = createStudentDtoMockData();
		when(paymentService.savePayment(payment)).thenReturn(payment);
		PaymentDto studentInfo = paymentController.savePayment(payment);
		assert(payment.getId() == studentInfo.getId());
	}
	
	
	@Test
	void updatePaymentTest() {
		//long id = 1;
		PaymentDto payment = createStudentDtoMockData();
		when(paymentService.updatePayment(payment)).thenReturn(payment);
		PaymentDto studentInfo = paymentController.updatePayment(payment);
		assert(payment.getId() == studentInfo.getId());
	}
	
	
	@Test
	void deletePaymentTest() {
		long id = 1;
		String msg = "Successfully Deleted Student";
		doNothing().when(paymentService).deletePayment(id);
		String message = paymentController.deletePayment(id);
		assert(message.equals(msg));
	}
	
	
	private PaymentDto createStudentDtoMockData(){
		PaymentDto payment = new PaymentDto();
		payment.setId(1);
		payment.setAmountpaid("500");
		payment.setDecription("fsdfsdfsdf");
		payment.setPaymentDate("dsfdsf");
		return payment;
		
	}
	
	

}
