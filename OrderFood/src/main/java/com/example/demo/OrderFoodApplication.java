package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.FoodItem;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderFoodApplication.class, args);
	}
	
	@Bean
	public FoodItem food() {
		return new FoodItem();
	}

}
