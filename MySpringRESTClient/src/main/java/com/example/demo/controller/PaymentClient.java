package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentClient {
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/showOnePayment")
	public String getPayment() {
		//return template.getForObject("http://localhost:4040/showPayment/", String.class);
		return template.getForObject("http://paymentms/showPayment", String.class);
	}
	
	@GetMapping("/showAllPayment")
	public String getAllPayment() {
		return template.getForObject("http://paymentms/showAll", String.class);
	}

}
