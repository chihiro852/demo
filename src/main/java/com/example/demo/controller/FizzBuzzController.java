package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FizzBuzzController {

	@GetMapping("/fizzBuzz")
	public String doGet() {
		return "fizzBuzz.html";
	}

	@PostMapping("btn")
	public String doPost(@RequestParam("no") String no, Model model) {
		try {
			int n = Integer.parseInt(no);

			for (int i = 1; i < n + 1; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					model.addAttribute("result", "FizzBuzz");
				} else if (i % 3 == 0) {
					model.addAttribute("result", "Fizz");
				} else if (i % 5 == 0) {
					model.addAttribute("result", "Buzz");
				} else {
					model.addAttribute("result", i);
				}
			}
		} catch (NumberFormatException e) {
			model.addAttribute("result", "数字を入力して下さい");
		}
		return "fizzBuzz.html";
	}
}