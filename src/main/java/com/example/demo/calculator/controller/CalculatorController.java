package com.example.demo.calculator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {


	private final CalculatorService calculatorService;
	
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String calculator(@RequestParam(value = "num1", defaultValue = " ") String num1Str, @RequestParam(value = "num2", defaultValue = " ") String num2Str,@RequestParam(value="operation", defaultValue=" ") String operation, Model model) {

		String result = " ";
		if (num1Str.isEmpty() || num2Str.isEmpty() || operation.isEmpty()) {
        } else {
			try {
	        	int num1 = Integer.parseInt(num1Str);
	        	int num2 = Integer.parseInt(num2Str);
	        	result = String.valueOf(calculatorService.calculator(operation, num1,num2));
	        	
			} catch (NumberFormatException e) {
	            model.addAttribute("result", " ");
			} catch (ArithmeticException e) {
				result = e.getMessage();
			} catch (IllegalArgumentException e) {
				result = e.getMessage();
			}
        }

		model.addAttribute("result", result);

		return "calculator";
	}
}
