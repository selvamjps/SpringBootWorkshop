package com.example.demo;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Payment;

@SpringBootApplication
public class MyConfigServerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyConfigServerClientApplication.class, args);
	}
	
	@Bean
	public Payment payment() {
		return new Payment(110, 500.00, "Driver Betta", LocalDate.of(2018, Month.MARCH, 15));
	}

}
