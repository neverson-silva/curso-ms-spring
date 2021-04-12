package com.neverson.hrpayroll.services.impl;

import com.neverson.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.neverson.hrpayroll.entities.Payment;
import com.neverson.hrpayroll.services.PaymentService;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hr-worker.host}")
	private String workerHost;

	public Payment getPayment(long workerId, int days) {

		Map<String, String> params = new HashMap<>();
		params.put("id", String.valueOf(workerId));

		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, params) ;

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
