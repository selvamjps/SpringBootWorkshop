package com.example.demo.domain;

import com.example.demo.contract.DiscountService;
import com.example.demo.utils.LogExecutionTime;

import lombok.ToString;

@ToString
public class Billing implements DiscountService {

	@Override
	public double cashDiscounts() {

		return 0.10;
	}

	@Override
	@LogExecutionTime
	public String[] getCoupons() {
		
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new String[] {"Shoppers Stop", "Pizza Hut", "Tata Sky"};
	}

}
