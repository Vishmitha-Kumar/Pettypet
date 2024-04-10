package com.pet.adoption.controller;


import com.pet.adoption.model.Payment;
import com.pet.adoption.model.User;
import com.pet.adoption.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/pay")
public class PaymentController {

    @Autowired
    private PaymentService paymentservice;

    @PostMapping("/save")
    public ResponseEntity<?> addpay(@RequestBody Payment payment){
        try{
            paymentservice.addpay(payment);
            return new ResponseEntity<>("Payment successfully!",HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
