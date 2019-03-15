package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.repos.PaymentRepo;
import com.example.demo.util.ClientView;
import com.fasterxml.jackson.annotation.JsonView;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentRepo repo;
	
	@Autowired
	@Qualifier("ramesh")
	private Payment paymentObj1;
	
	@Autowired
	@Qualifier("suresh")
	private Payment paymentObj2;
	
	@Autowired
	private List<Payment> paymentList;
	
	@GetMapping("/showPayment")
	@ApiOperation (value = "Returns Payment Details")
	public Payment getPayment() {
		
		return paymentObj1;
	}
	
	@GetMapping("/showAll")
	@JsonView(ClientView.class)
	public List<Payment> findAll() {
		
		return repo.findAll();
	}
	
	@PostMapping("/addPayment")
	@ApiOperation (value = "This method return")
	public Payment addPayment(@ApiParam("Takes payment details") @RequestBody Payment payment) {
		return repo.save(payment);
	}
	
	@GetMapping("/findByName/{customerName}")
	public Payment getPaymentByName(@PathVariable String customerName) {
		
		if("suresh".equalsIgnoreCase(customerName)) {
			return paymentObj2;
		}
		
		return paymentObj1;
	}

}
