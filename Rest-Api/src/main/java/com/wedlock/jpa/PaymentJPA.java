package com.wedlock.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedlock.entities.Payment;

public interface PaymentJPA extends JpaRepository<Payment, Long>{

}
