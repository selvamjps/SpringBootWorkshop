package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Payment {

	private long tripId;
	private PartnerDriver driver;
	private double amount;
	
	public Payment() {
		super();
		
		System.out.println(":::::::: Payment Constructor Invoked ::::::::::");
	}

	public Payment(long tripId, PartnerDriver driver, double amount) {
		super();
		this.tripId = tripId;
		this.driver = driver;
		this.amount = amount;
	}

	public long getTripId() {
		return tripId;
	}
	
	@Value("10045")
	public void setTripId(long tripId) {
		System.out.println("SET TRIP ID CALLED");
		this.tripId = tripId;
	}

	public PartnerDriver getDriver() {
		return driver;
	}

	@Autowired
	public void setDriver(PartnerDriver driver) {
		System.out.println("SET DRIVER NAME CALLED");
		this.driver = driver;
	}

	public double getAmount() {
		return amount;
	}

	@Value("420.75")
	public void setAmount(double amount) {
		System.out.println("SET AMOUNTD CALLED");
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [tripId=" + tripId + ", driver=" + driver + ", amount=" + amount + "]";
	}
}