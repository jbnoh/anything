package com.anything.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

	@Around("within(com.anything..*)")
	public Object logAction(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result = joinPoint.proceed(joinPoint.getArgs());
		try {
			return result;
		} finally {
			log.info("");
		}
	}
}
