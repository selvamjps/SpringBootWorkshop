package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FoodItem;

@RestController
public class OrderFoodController {
	
	@Autowired
	FoodItem foodItem;

	@GetMapping("/order/{itemName}/{type}/{quantity}")
	public String orderItem(@PathVariable String itemName, @PathVariable String type, @PathVariable double quantity) {
		
		foodItem.setItemName(itemName);
		foodItem.setType(type);
		foodItem.setQuantity(quantity);
		
		return foodItem.toString() + " Ordered Successfully !!!";
	}
}
