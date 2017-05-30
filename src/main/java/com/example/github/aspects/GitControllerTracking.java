package com.example.github.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintStream;

/**
 * Created by yshpyluk on 5/30/17.
 */
@Aspect
public class GitControllerTracking {
	@Autowired
	public PrintStream stream;

	@Before("execution(* com.example.github.GitController.getUsers())")
	public void logGetUsersRequest() {
		stream.println("getUsers endpoint is going to be triggered");
	}

	@Around("execution(* com.example.github.GitController.getUser(String)) " +
			"&& args(userName)")
	public void aroundGetUser(ProceedingJoinPoint jp, String userName) throws Throwable {
		stream.println("before getUser triggering with " + userName + " username");

		try {
			jp.proceed();
		} catch (Throwable throwable) {
			stream.println("exception in getUser endpoint with " + userName + " username");
			stream.println(throwable.getMessage());
			throw throwable;
		}

		stream.println("after getUser triggering with " + userName + " username");
	}
}
