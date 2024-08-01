package com.example.demo.fizzBuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {
	
	private final FizzBuzzService fizzBuzzService;
	
	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		
		this.fizzBuzzService = fizzBuzzService;
	}
	
	@GetMapping("fizzBuzz")
	public String fizzBuzz(Model model) {
		
		List<String> result = fizzBuzzService.fizzBuzz(100);
		 
		 model.addAttribute("numbers", result);
		 
		 return "fizzBuzz.html";
	}

}
