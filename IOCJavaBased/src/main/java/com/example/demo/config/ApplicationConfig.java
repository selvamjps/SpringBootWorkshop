package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Library;

@Configuration
public class ApplicationConfig {
	
	@Autowired
	Author defaultAuthor;
	
	@Autowired
	DomainConfig config;
	
	@Bean(name="firstAuthor")
	public Author author() {
		return new Author(101, "Ramesh");
	}
	
	@Bean
	@Lazy(value=true)
	public Book book() {
		//return  new Book(101, "Spring in Action", author());
		return new Book(109, "Spring in Action", defaultAuthor);
		//return  new Book(109, "Spring in Action", config.author());
	}
	
	@Bean(initMethod="init", destroyMethod="destory")
	public Book springBook() {
		return new Book(109, "Spring in Action", author());
	}
	
	@Bean(initMethod="init", destroyMethod="destory")
	public Book javaBook() {
		return new Book(109, "Java 10", author());
	}
	
	@Bean(initMethod="init", destroyMethod="destory")
	public Book dotNetBook() {
		return new Book(109, "Mastering DOT NET", author());
	}
	
	@Bean
	public Library library() {
		
		Library connemaraLibrary = new Library();
		connemaraLibrary.setLibraryName("Connemara Library");
		
		return connemaraLibrary;
	}

}
