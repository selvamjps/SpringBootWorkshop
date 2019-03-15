package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.PartnerDriver;

@SpringBootApplication
public class MySpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringMvcApplication.class, args);
	}
	
	@Bean
	public PartnerDriver partnerDriver() {
		return new PartnerDriver();
	}
	
	@Bean
	public ModelAndView modelAndView() {
		return new ModelAndView();
	}

}
