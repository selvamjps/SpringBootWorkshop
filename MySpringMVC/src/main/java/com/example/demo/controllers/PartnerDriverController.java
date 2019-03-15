package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.PartnerDriver;
import com.example.demo.repo.DriverRepository;

@Controller
public class PartnerDriverController {
	
	@Autowired
	private PartnerDriver driver;
	
	@Autowired
	private DriverRepository repo;
	
	@Autowired
	private ModelAndView mdview;
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@GetMapping("/addDriver")
	public ModelAndView sendForm() {
		mdview.addObject("command", driver);
		mdview.setViewName("addCabDriver");
		return mdview;
	}
	
	@PostMapping("/addDriver")
	public String onSubmit(@ModelAttribute("passedBean") PartnerDriver driver) {
		
		PartnerDriver response = repo.save(driver);
		
		return "success";
	}

}
