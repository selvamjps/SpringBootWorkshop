package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DonorSerachController {

	@Autowired
	public RestTemplate template;
	
	@Autowired
	public LoadBalancerClient balancedClient;
	
	@GetMapping("/searchDonor/{bloodGroup}")
	public String searchForDonor(@PathVariable String bloodGroup) {
		
		ServiceInstance serviceInstance = balancedClient.choose("donorproducerms");
		
		System.out.println(serviceInstance.getUri());
		
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/search/" + bloodGroup;
		
		String response = template.getForObject(baseUrl, String.class);
		
		return response;
	}
}
