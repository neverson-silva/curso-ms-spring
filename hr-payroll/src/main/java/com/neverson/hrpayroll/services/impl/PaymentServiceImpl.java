package com.neverson.hrpayroll.services.impl;

import org.springframework.stereotype.Service;

import com.neverson.hrpayroll.entities.Payment;
import com.neverson.hrpayroll.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.00, days);
	}

}
