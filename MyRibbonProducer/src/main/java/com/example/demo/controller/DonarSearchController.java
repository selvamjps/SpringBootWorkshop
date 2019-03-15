package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonarSearchController {
	
	@GetMapping("/search/{bloodGroup}")
	public String getDonarByGroup(@PathVariable String bloodGroup) { 
		String donorName = "Ramesh";
		
		if(bloodGroup.equalsIgnoreCase("bpos")) {
			donorName = "Rajesh";
		}
		
		return donorName;
	}

}
