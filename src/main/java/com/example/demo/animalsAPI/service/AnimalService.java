package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.repository.AnimalRepository;

@Service
public class AnimalService {

	private final AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public List<AnimalData> getAnimalData() throws IOException {

		AnimalData[] animalDataList = animalRepository.getAnimalData();

		return Arrays.asList(animalDataList);
	}
}
