package com.neverson.hrpayroll.services;

import com.neverson.hrpayroll.entities.Payment;

public interface PaymentService {

	Payment getPayment(long workerId, int days);
}
