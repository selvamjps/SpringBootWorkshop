package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.advices.CalculateTime;
import com.example.demo.advices.FestivalOffer;
import com.example.demo.contract.DiscountService;
import com.example.demo.domain.Billing;

@Configuration
public class ApplicationConfig {

	@Bean
	public DiscountService service() {
		return new Billing();
	}
	
	@Bean
	public FestivalOffer offer() {
		return new FestivalOffer();
	}
	
	@Bean
	public CalculateTime time() {
		return new CalculateTime();
	}
	
}
