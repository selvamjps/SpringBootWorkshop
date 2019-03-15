package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

@RestController
public class MyConfigClientController {
	
	@Autowired
	PaymentService service;
	
	@Autowired
	Payment payment;
	
	@GetMapping(name="/getAllPayments")
	public String getAllPayments() {
		return service.getAllPayments().toString();
	}

}
