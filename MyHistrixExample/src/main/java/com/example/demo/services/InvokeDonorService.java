package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class InvokeDonorService {

	@Autowired
	public RestTemplate template;
	
	@Autowired
	public LoadBalancerClient balancedClient;
	
	@HystrixCommand(fallbackMethod="myHystrixFallBack")
	public String invoke(String bloodGroup) {
		
		ServiceInstance instance = balancedClient.choose("donorproducerms");
		
		System.out.println(instance.getUri());
		
		String baseUrl = instance.getUri().toString();
		baseUrl = baseUrl + "/search/" + bloodGroup;
		
		System.out.println("Complete URL ::: " + baseUrl);
		
		String response = template.getForObject(baseUrl, String.class);
		
		System.out.println("response ::" + response);
		
		return response;
	}
	
	public String myHystrixFallBack(String bloodGroup) {
		return "Requested service down at this moment and will be up shortly";
		
	}
}
