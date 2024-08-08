package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	public int minus(int num1, int num2) {
		return num1 - num2;
	}
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	public int division(int num1, int num2) {
		if(num2 == 0) {
			throw new ArithmeticException("ゼロは除算できません");
		}
		return num1 / num2;
	}


	public int calculator(String operation, int num1, int num2) {
		switch(operation) {
		case "add":
			return add(num1, num2);
			
		case "minus":
			return minus(num1, num2);
			
		case "multiply":
			return multiply(num1, num2);
		
		case "division":
			return division(num1, num2);
		
		default:
			throw new IllegalArgumentException(" ");
		}
	}
}
