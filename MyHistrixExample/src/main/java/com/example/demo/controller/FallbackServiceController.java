package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.InvokeDonorService;

@RestController
public class FallbackServiceController {

	@Autowired
	public InvokeDonorService service;
	
	@GetMapping("/searchwithfallback/{group}")
	public String getDetails(@PathVariable String group) {
		return service.invoke(group);
	}
}
