package com.pet.adoption.repository;


import com.pet.adoption.model.Payment;
import com.pet.adoption.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {
    Optional<Payment> findByEmail(String email);


}