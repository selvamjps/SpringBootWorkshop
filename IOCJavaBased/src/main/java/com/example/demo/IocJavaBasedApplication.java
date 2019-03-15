package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Library;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class IocJavaBasedApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IocJavaBasedApplication.class, args);
		
		log.info(((Author)ctx.getBean("defaultAuthor")).toString());
		log.info(((Author)ctx.getBean("firstAuthor")).toString());
		log.info(((Author)ctx.getBean("secondAuthor")).toString());
		
		log.info(((Book)ctx.getBean("book")).toString());
		
		Library library = (Library)ctx.getBean("library");
		
		log.info(library.toString());
		
		//Prints the list asis
		library.getBookList().forEach(System.out::println);
		
		//Extracts the book name and populates the list and prints
		library.getBookList().stream().map((book)-> book.getBookName()).forEach(System.out::println);
		
		//Extracts the book name and populates the list. Later iterates and prints it
		List<String> bookList = library.getBookList().stream().map((book)-> book.getBookName()).collect(Collectors.toList());
		bookList.forEach(System.out::println);
	}
	
	@Bean(name="defaultAuthor")
	public Author author() {
		return new Author(102, "Panneer");
	}

}
