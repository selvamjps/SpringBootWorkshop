package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.domain.TrainingProvider;

@SpringBootApplication
public class MethodInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MethodInjectionApplication.class, args);
		
		TrainingProvider provider = (TrainingProvider)ctx.getBean("provider");
		provider.getFreshCourses();
		
		TrainingProvider provider1 = (TrainingProvider)ctx.getBean("provider");
		provider1.getFreshCourses();
		
		TrainingProvider provider2 = (TrainingProvider)ctx.getBean("provider");
		provider2.getFreshCourses();
	}

}
