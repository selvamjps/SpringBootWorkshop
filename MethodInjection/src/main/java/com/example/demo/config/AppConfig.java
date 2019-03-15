package com.example.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.domain.Course;
import com.example.demo.domain.TrainingProvider;

@Configuration
public class AppConfig {

	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TrainingProvider provider() {
		return new TrainingProvider() {
			@Override
			public Course getFreshCourses() {
				System.out.println("Lookup Method Called");
				return new Course();
			}
		};
	}
	
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Course course() {
		return new Course();
	}
}
