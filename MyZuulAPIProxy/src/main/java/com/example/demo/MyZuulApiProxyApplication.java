package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.demo.filters.MyPreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class MyZuulApiProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyZuulApiProxyApplication.class, args);
	}
	
	@Bean
	public MyPreFilter filter() {
		return new MyPreFilter();
	}

}
