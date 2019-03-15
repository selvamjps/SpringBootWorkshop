package com.example.demo.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculateTime {
	
	@Around("@annotation(com.example.demo.utils.LogExecutionTime)")
	public Object countTime(ProceedingJoinPoint jp) throws Throwable {
		
		long current  = System.currentTimeMillis();
		
		Object obj = jp.proceed();
		
		long now  = System.currentTimeMillis();
		
		long timeElapsed = now - current;
		
		System.out.println("Method Completed On : " + timeElapsed);
		
		return obj;
		
	}

}
