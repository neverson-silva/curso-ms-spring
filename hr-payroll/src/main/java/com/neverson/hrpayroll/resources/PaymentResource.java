package com.neverson.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neverson.hrpayroll.entities.Payment;
import com.neverson.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping("{workerId}/days/{days}")
    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId,
                                              @PathVariable("days") Integer days) {

        Payment payment = service.getPayment(workerId, days);

        return ResponseEntity.ok(payment);

    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {

        Payment payment = new Payment("Brann", 400.0, days);

        return ResponseEntity.ok(payment);
    }
}
