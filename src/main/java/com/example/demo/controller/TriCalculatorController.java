package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.TriCalculatorService;

@Controller
public class TriCalculatorController {
	public final TriCalculatorService triCalculatorService;

	@Autowired
	public TriCalculatorController(TriCalculatorService triCalculatorService) {
		this.triCalculatorService = triCalculatorService;
	}

	@GetMapping("/triCalculator")
	public String doGet(@RequestParam("str1") String str1, @RequestParam("str2") String str2,
			@RequestParam("str3") String str3,
			@RequestParam("symbol1") String symbol1,
			@RequestParam("symbol2") String symbol2,
			Model model) {
		return "triCalculator.html";
	}

	@PostMapping("triCalculator")
	public String doPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2,
			@RequestParam("str3") String str3,
			@RequestParam("symbol1") String symbol1,
			@RequestParam("symbol2") String symbol2,
			Model model) {
		String result = triCalculatorService.calculator(symbol1, symbol2, str1, str2, str3);

		model.addAttribute("result", result);
		return "triCalculator.html";
	}
}