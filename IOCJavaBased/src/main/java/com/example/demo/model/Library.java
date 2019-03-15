package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Library {
	
	@Setter
	private String libraryName;
	
	@Autowired(required=false)
	List<Book> bookList;
}
