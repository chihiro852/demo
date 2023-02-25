package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FizzBuzzController {
	int fizz;
	int buzz;
	int fizzBuzz;
	String all[];

	
	@GetMapping("/fizzBuzz")
	public String doGet() {
		return "fizzBuzz.html";
	}
	
	@PostMapping("btn")
	public String doPost( Model model) {
		fizz = all();
		
		model.addAttribute("fizz", fizz);
		return "fizzBuzz.html";
	}
	
	public int all() {
		List<Integer> list = new ArrayList<>();
		return fizz;
	}
}