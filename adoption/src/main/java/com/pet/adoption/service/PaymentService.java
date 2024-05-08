package com.pet.adoption.service;



import java.util.Optional;

import com.pet.adoption.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.adoption.model.Payment;
import com.pet.adoption.repository.PaymentRepository;


@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addpay(Payment payment) {
        Optional<Payment> userExists = paymentRepository.findByEmail(payment.getEmail());
        if (userExists.isPresent())
            throw new IllegalArgumentException("Email already exist");
        else
            return paymentRepository.save(payment);
    }
}