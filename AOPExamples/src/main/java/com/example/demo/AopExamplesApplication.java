package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.contract.DiscountService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopExamplesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AopExamplesApplication.class, args);
		
		DiscountService discountService = ((DiscountService) ctx.getBean("service"));
		
		System.out.println("discountService ::" + discountService.getClass());
		
		System.out.println("Cash Discounts = " + discountService.cashDiscounts());
		
		String[] coupons = (String[])discountService.getCoupons();
		
		for(String coupon : coupons) {
			System.out.println("Coupon Name ::" + coupon);
		}
	}

}
