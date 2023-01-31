package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Payment;
import ksmart42.khtour.mapper.PaymentMapper;

@Service
@Transactional
public class PaymentService {
	
	private PaymentMapper paymentMapper;
	
	@Autowired
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}

	public List<Payment> getPayDetail(Map<String, Object> paramMap) {
		
		List<Payment> payDetail = paymentMapper.getPayDetail();

		return payDetail;
	}

}
