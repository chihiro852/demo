package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.AdditionService;
import com.example.demo.Service.DivisionService;
import com.example.demo.Service.MinusService;
import com.example.demo.Service.MultiplicationService;

@Controller
public class CalculatorController {
	private final AdditionService additionService;
	private final MinusService minusService;
	private final MultiplicationService multiplicationService;
	private final DivisionService divisionService;

	@Autowired
	public CalculatorController(AdditionService additionService, MinusService minusService,
			MultiplicationService multiplicationService, DivisionService divisionService) {
		this.additionService = additionService;
		this.minusService = minusService;
		this.multiplicationService = multiplicationService;
		this.divisionService = divisionService;
	}

	@GetMapping("calculator")
	public String doGet() {
		return "calculator";
	}

	@PostMapping(value = "calculator", params = "add")
	public String addPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = additionService.addParam(str1, str2);

		model.addAttribute("result", result);

		return "calculator";
	}

	@PostMapping(value = "calculator", params = "minus")
	public String minusPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = minusService.minusParam(str1, str2);

		model.addAttribute("result", result);

		return "calculator";
	}

	@PostMapping(value = "calculator", params = "multiplication")
	public String mltPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = multiplicationService.mltParam(str1, str2);

		model.addAttribute("result", result);

		return "calculator";
	}

	@PostMapping(value = "calculator", params = "division")
	public String dvsPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = divisionService.dvsParam(str1, str2);

		model.addAttribute("result", result);

		return "calculator";
	}
}