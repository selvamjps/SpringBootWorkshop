package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

@Repository
public class PaymentService {
	
	@Autowired
	PaymentRepository repo;

	public Payment addPayment(Payment payment) {
		return repo.save(payment);
	}
	
	public Iterable<Payment> getAllPayments() {
		return repo.findAll();
	}
}
