package com.spbl.lamda;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Test;

public class TestLamda {
	private interface MathOperation {
		int operation (int a, int b);
	}
	
	private interface GreetingService {
	void sayMessage(String message);
	}
	@Test
	public void testRun() {
		Runnable r1 = () -> System.out.println("hello world");
		r1.run();
	}
	
	@Test
	public void changeToOneMethodInterface() {
		MathOperation addition = (int a, int b) -> a+b;
		MathOperation subtraction = (a,b) -> a-b;
		MathOperation multiplication = (int a, int b) -> {return a*b;};
		//without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;
		System.out.println("10 + 5 = " + operate(10, 5, addition));
		System.out.println("10 - 5 = " + operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + operate(10, 5, division));
		//with parenthesis
		GreetingService greetService1 = message ->
		System.out.println("Hello " + message);
		//without parenthesis
		GreetingService greetService2 = (message) ->
		System.out.println("Hello " + message);
		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
	}
	
	private int operate(int i, int j, MathOperation addition) {
		return addition.operation(i, j);
	}

}
