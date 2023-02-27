package com.example.demo.controller;

import java.util.ArrayList;

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
			ArrayList<String> list = new ArrayList<>();

			for (int i = 1; i < n + 1; i++) {
				if (i % 15 == 0) {
					list.add("FizzBuzz");
				} else if (i % 3 == 0) {
					list.add("Fizz");
				} else if (i % 5 == 0) {
					list.add("Buzz");
				} else {
					list.add(String.valueOf(i));
				}
			}
			model.addAttribute("result", list);
		} catch (NumberFormatException e) {
			model.addAttribute("result", "整数を入力して下さい");
		}
		return "fizzBuzz.html";
	}
}