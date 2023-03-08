package com.example.demo.Service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PracticeAPIRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class PracticeAPIService {
	private final PracticeAPIRepository practiceAPIRepository;

	@Autowired
	public PracticeAPIService(PracticeAPIRepository practiceAPIRepository) {
		this.practiceAPIRepository = practiceAPIRepository;
	}

	public Map<String, Object> ser() throws JsonMappingException, JsonProcessingException {
		Map<String, Object> map = new LinkedHashMap<>();

		map = practiceAPIRepository.rep();

		//for ()

		return map;
	}
}