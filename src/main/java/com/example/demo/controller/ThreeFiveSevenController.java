package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ThreeFiveSevenService;

@Controller
public class ThreeFiveSevenController {

	private final ThreeFiveSevenService threeFiveSevenService;

	@Autowired
	public ThreeFiveSevenController(ThreeFiveSevenService threeFiveSevenService) {
		this.threeFiveSevenService = threeFiveSevenService;
	}

	@GetMapping("threeFiveSeven")
	public String doGet() {
		return "threeFiveSeven";
	}

	@PostMapping("threeFiveSeven")
	public String doPost(@RequestParam("str") String str, Model model) {
		ArrayList<String> list = new ArrayList<>();

		list = threeFiveSevenService.doList(str);

		model.addAttribute("list", list);

		return "threeFiveSeven";
	}
}