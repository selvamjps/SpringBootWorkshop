package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="mvcdriver")
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDriver {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long driverId;
	private String driverName;
	private long mobileNumber;
	private double rating;

}
