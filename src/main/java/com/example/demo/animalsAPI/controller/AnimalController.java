package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {

	private final AnimalService animalService;
	
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}
	
	@GetMapping("/animal-search")
	public String getAnimalData(Model model) throws IOException {
		
		List<AnimalData> animalDataList = animalService.getAnimalData();
		
		model.addAttribute("animalDataList", animalDataList);
		
		return "animal-search";
	}
	
	@PostMapping("/animal-detail")
	   public String animalDetailUser(@RequestParam("name") String name, Model model) throws IOException {
        List<AnimalData> animalDataList = animalService.getAnimalData();
        AnimalData selectedAnimal = animalDataList.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (selectedAnimal != null) {
            model.addAttribute("animalDataList", List.of(selectedAnimal));
        } else {
            model.addAttribute("animalDataList", List.of());
        }

        return "animal-detail";
	}
}
