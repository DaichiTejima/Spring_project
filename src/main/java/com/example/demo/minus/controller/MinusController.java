package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService;

	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("minus")
	public String minus(@RequestParam(value="num1", defaultValue=" ") String num1Str, @RequestParam(value="num2", defaultValue=" ") String num2Str, Model model) {
		
        int num1 = 0;
        int num2 = 0;
        try {
            if (!num1Str.isEmpty()) {
                num1 = Integer.parseInt(num1Str);
            }
            if (!num2Str.isEmpty()) {
                num2 = Integer.parseInt(num2Str);
            }
        } catch (NumberFormatException e) {
            model.addAttribute("result", " ");
            return "minus";
        }

		
		int result = minusService.minus(num1, num2);
		
		model.addAttribute("result", result);

		return "minus";
	}

}
