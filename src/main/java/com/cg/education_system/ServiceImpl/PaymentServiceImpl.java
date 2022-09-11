package com.cg.education_system.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.education_system.Exception.PaymentNotFoundExcption;
import com.cg.education_system.Exception.StudentNotFoundExcption;
import com.cg.education_system.Service.PaymentService;
import com.cg.education_system.Service.ProgressService;
import com.cg.education_system.dto.PaymentDto;
import com.cg.education_system.dto.ProgressDto;
import com.cg.education_system.entity.Payment;
import com.cg.education_system.entity.Progress;
import com.cg.education_system.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	Log LOGGER = LogFactory.getFactory().getLog(PaymentService.class);
	@Autowired
	PaymentRepository paymentRepo;
	
	
	@Override
	public List<PaymentDto> getAllPayment() {
		LOGGER.info("PaymentServiceImpl::getAllPayment::Entered");
		List<PaymentDto> payments = new ArrayList<>();
		
		List<Payment> paymentList = paymentRepo.findAll();
		paymentList.stream().forEach(payment -> {
			PaymentDto paymentDto = new PaymentDto();
			paymentDto.setId(payment.getId());
			paymentDto.setPaymentDate(payment.getPaymentDate());
			paymentDto.setDecription(payment.getDecription());
			paymentDto.setAmountpaid(payment.getAmountpaid());
			payments.add(paymentDto);
		});
		LOGGER.info("PaymentServiceImpl::getAllPayment::Exited");
		return payments;
	}
	
	@Override
	public PaymentDto getPayment(long id) {
		LOGGER.info("PaymentServiceImpl::getPayment::Entered");
		Optional<Payment> paymentopt = paymentRepo.findById(id);
		PaymentDto paymentDto = new PaymentDto();
		if(paymentopt.isPresent()) {
			Payment payment = paymentopt.get();
			paymentDto.setAmountpaid(payment.getAmountpaid());
			paymentDto.setId(payment.getId());
			paymentDto.setDecription(payment.getDecription());
			paymentDto.setPaymentDate(payment.getPaymentDate());
			//paymentDto.setPayment(payment.getPayment());
		}
		else{
			throw new PaymentNotFoundExcption("Payment with id::"+id+" Not found");
		}
		LOGGER.info("PaymentServiceImpl::getPayment::exited");
		return paymentDto;
	}

	@Override
	public PaymentDto savePayment(PaymentDto payment) {
		LOGGER.info("PaymentServiceImpl::savePayment::entered");
		Payment paymentEntity = new Payment();
		paymentEntity.setAmountpaid(payment.getAmountpaid());
		paymentEntity.setId(payment.getId());
		paymentEntity.setDecription(payment.getDecription());
		paymentEntity.setPaymentDate(payment.getPaymentDate());
		//paymentEntity.setPayment(payment.getPayment());
		paymentRepo.save(paymentEntity);
		payment.setId(paymentEntity.getId());
		
		LOGGER.info("PaymentServiceImpl::savePayment::exited");
		return payment;
	}

	@Override
	public PaymentDto updatePayment(PaymentDto payment) {
		LOGGER.info("PaymentServiceImpl::updatePayment::entered");
		Payment paymentEntity = new Payment();
		paymentEntity.setAmountpaid(payment.getAmountpaid());
		paymentEntity.setId(payment.getId());
		paymentEntity.setDecription(payment.getDecription());
		paymentEntity.setPaymentDate(payment.getPaymentDate());
		//paymentEntity.setPayment(payment.getPayment());
		paymentRepo.save(paymentEntity);
		LOGGER.info("PaymentServiceImpl::updatePayment::exited");
		return payment;
	}

	@Override
	public void deletePayment(long Id) {
		paymentRepo.deleteById(Id);
		
	}

	

}
