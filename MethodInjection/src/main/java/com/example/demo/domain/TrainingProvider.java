package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class TrainingProvider {

	Course course;
	
	@Lookup
	public abstract Course getFreshCourses();
	
	public TrainingProvider() {
		super();
		System.out.println("[SINGLETON] Training Provider Called");
	}
	
	public TrainingProvider(Course course) {
		super();
		
		this.course = course;
		
		System.out.println("[SINGLETON] Training Provider Called");
	}
}
