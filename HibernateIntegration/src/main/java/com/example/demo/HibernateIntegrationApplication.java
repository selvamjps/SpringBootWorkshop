package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Book;
import com.example.demo.service.BookServiceImpl;

@SpringBootApplication
public class HibernateIntegrationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HibernateIntegrationApplication.class, args);
		
		BookServiceImpl service = ctx.getBean(BookServiceImpl.class);
		Long bookAdded = service.addBook(ctx.getBean(Book.class));
		
		System.out.println("One book added with details ::: "+ bookAdded);
		
		service.getBooks().forEach(System.out::println);
	}
	
	@Bean
	public Book book() {
		return new Book(111, "Head First java", 450);
	}

}
