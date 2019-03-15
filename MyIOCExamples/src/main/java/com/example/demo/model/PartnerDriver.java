package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString
@AllArgsConstructor
@Component
public class PartnerDriver {
	
	private int driverId;
	private String driverName;
	private long  mobileNumber;
	private double rating;
	
	public PartnerDriver() {
		super();
		log.info("Partner Driver Initialized");
	}

}
