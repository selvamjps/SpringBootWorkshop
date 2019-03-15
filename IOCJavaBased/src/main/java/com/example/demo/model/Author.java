package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
	
	private long authorId;
	private String authorName;
	
	public Author() {
		System.out.println("******* Author Constructor Invoked ******");
	}

}
