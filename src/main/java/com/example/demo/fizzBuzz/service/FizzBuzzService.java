package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
	
	public List<String> fizzBuzz(int limit) {
		List<String> numbers = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				numbers.add("FizzBuzz");
			} else if (i % 3 == 0) {
				numbers.add("Fizz");
			} else if (i % 5 == 0) {
				numbers.add("Buzz");
			} else {
				numbers.add(String.valueOf(i));
			}
		}
		return numbers;
	}
}





	