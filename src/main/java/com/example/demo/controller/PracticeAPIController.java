package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.PracticeAPIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class PracticeAPIController {
	private final PracticeAPIService practiceAPIService;

	@Autowired
	public PracticeAPIController(PracticeAPIService practiceAPIService) {
		this.practiceAPIService = practiceAPIService;
	}

	@GetMapping("practiceAPI")
	public String doGet(Model model) throws JsonMappingException, JsonProcessingException {
		Map<String, Object> result = new LinkedHashMap<>();

		result = practiceAPIService.ser();

		System.out.println(result.get("data"));
		System.out.println(result.get("name"));

		model.addAttribute("result", result);

		return "practiceAPI.html";
	}
}