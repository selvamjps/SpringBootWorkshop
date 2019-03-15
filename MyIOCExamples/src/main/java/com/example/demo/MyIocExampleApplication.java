package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.PartnerDriver;
import com.example.demo.model.Payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MyIocExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MyIocExampleApplication.class, args);
		
		Payment paymentBean = ctx.getBean(Payment.class);
		
		PartnerDriver driver = paymentBean.getDriver();
		
		driver.setDriverId(2389456);
		driver.setDriverName("Panneer");
		driver.setMobileNumber(5654654);
		driver.setRating(5);
		
		log.info(paymentBean.toString());
	}

}
