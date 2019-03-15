package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@NoArgsConstructor
public class Book {
	
	@Getter
	@Setter
	private long bookNumber;
	
	@Getter
	@Setter
	private String bookName;
	
	@Getter
	@Setter
	private Author author;
	
	@Autowired
	private Environment env;
	

	public Book(long bookNumber, String bookName, Author author) {
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
	}
	
	public void init() {
		log.info("Initialized");
		
		String[] profiles = env.getActiveProfiles();
		
		for(String profile : profiles) {
			log.info("Profile :: " + profile);
		}
	}
	
	public void destory() {
		log.info("Destroyed");
	}

}
