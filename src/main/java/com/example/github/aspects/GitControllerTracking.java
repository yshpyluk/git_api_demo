package com.example.github.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GitControllerTracking {

	@Before("execution(* com.example.github.GitController.getUsers())")
	public void logGetUsersRequest() {
		log.info("getUsers endpoint is going to be triggered");
	}

	@Around("execution(* com.example.github.GitController.getUser(String)) " +
			"&& args(userName)")
	public Object aroundGetUser(ProceedingJoinPoint jp, String userName) throws Throwable {
		log.info("before getUser triggering with " + userName + " username");

		try {
			Object obj =  jp.proceed();
			log.info("after getUser triggering with " + userName + " username");
			return obj;
		} catch (Throwable throwable) {
			log.info("exception in getUser endpoint with " + userName + " username");
			log.info(throwable.getMessage());
			throw throwable;
		}
	}
}
