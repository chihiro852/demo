package com.example.demo.controller;

import java.util.ArrayList;

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
		ArrayList<String> list = new ArrayList<>();

		list = practiceAPIService.ser();

		model.addAttribute("result", list);

		return "practiceAPI.html";
	}
}