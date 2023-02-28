package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.DivisionService;

@Controller
public class DivisionController {
	private final DivisionService divisionService;

	@Autowired
	public DivisionController(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@GetMapping("division")
	public String doGet() {
		return "division";
	}

	@PostMapping("form")
	public String doPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = divisionService.dvsParam(str1, str2);

		model.addAttribute("result", result);
		return "division";
	}
}