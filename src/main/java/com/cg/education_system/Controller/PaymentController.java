package com.cg.education_system.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.education_system.Service.PaymentService;
import com.cg.education_system.dto.CourseDto;
import com.cg.education_system.dto.PaymentDto;

@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class PaymentController {
	Log LOGGER = LogFactory.getFactory().getLog(PaymentController.class);
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/Payment")
	public List<PaymentDto> getAllPayment(){
		LOGGER.info("paymentController::getAllPayment::Entered");
		List<PaymentDto> payment = paymentService.getAllPayment();
		System.out.println(payment);
		LOGGER.info("paymentController::getAllPayment::Exited");
		return payment;
	}
	
	@GetMapping("/Payment/{id}")
	public PaymentDto getPayment(@PathVariable("id") long id) {
		LOGGER.info("paymentController::getPayment::Entered");
		PaymentDto paaymentDto = paymentService.getPayment(id);
		System.out.println(paaymentDto);
		LOGGER.info("paymentController::getPayment::exiter");
		return paaymentDto;
		
	}
	@Validated
	@PostMapping("/Payment")
	public PaymentDto savePayment(@RequestBody @Valid PaymentDto payment) {
		LOGGER.info("paymentController::savePayment::Entered");
		PaymentDto paaymentDto = paymentService.savePayment(payment);
		System.out.println("Successfully added  "+ payment);
		LOGGER.info("paymentController::savePayment::exited");
	//	System.out.println("Successfully added payment "+ payment);
		return paaymentDto;
		
	}
	
	
	@PutMapping("/Payment/{id}")
	public PaymentDto updatePayment(@RequestBody PaymentDto payment) {
		LOGGER.info("paymentController::updatePayment::Entered");
		PaymentDto paaymentDto = paymentService.updatePayment(payment);
		System.out.println("Successfully updated payment "+ payment);
		LOGGER.info("paymentController::updatePayment::exited");
		return paaymentDto;
	}
	
	@DeleteMapping("/Payment/{id}")
	public String deletePayment(@PathVariable("id") Long Id) {
		paymentService.deletePayment(Id);
		//System.out.println("Successfully deleted payment with id :" + Id);
		return "Successfully Deleted Student";
	}
	

}
