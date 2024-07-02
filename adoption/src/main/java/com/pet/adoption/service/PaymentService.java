
package com.pet.adoption.service;

import com.pet.adoption.model.Payment;
import com.pet.adoption.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void addpay(Payment payment) {
        paymentRepository.save(payment);
    }
}
