package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService;

	@Autowired
	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("/minus")
	public String doGet() {
		return "minus.html";
	}

	@PostMapping("minus")
	public String doPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String rslt = minusService.minusParam(str1, str2);

		model.addAttribute("rslt", rslt);

		return "minus.html";
	}
}