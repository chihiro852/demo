package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.MultiplicationService;

@Controller
public class MultiplicationController {
	private final MultiplicationService multiplicationService;

	@Autowired
	public MultiplicationController(MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}

	@GetMapping("/multiplication")
	public String doGet() {
		return "multiplication.html";
	}

	@PostMapping("multiplication")
	public String doPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = multiplicationService.mltParam(str1, str2);

		model.addAttribute("result", result);

		return "multiplication.html";
	}
}