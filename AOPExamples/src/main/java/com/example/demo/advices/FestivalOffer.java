package com.example.demo.advices;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class FestivalOffer {
	
	@Before("execution(* com.example.demo.domain.*.*(..))")
	public void pongalOffer(JoinPoint jp) {
		log.info("Pongal Offer Called On ::::: " + jp);
	}
	
	@Around("execution(* com.example.demo.domain.*.*(..))")
	public Object pongalOffer(ProceedingJoinPoint jp) throws Throwable {
		log.info("First Part of Around Advice Called ....");
		
		Object obj = jp.proceed();
		
		if (obj instanceof Number) {
			Double current = (Double) obj;
			current = current + 0.5;
			
			return current;
		}
		
		log.info("Second Part of Around Advice Called ....");
		
		return obj;
	}

}
