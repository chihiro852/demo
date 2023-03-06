package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.TextLinkService;

@Controller
public class TextLinkController {
	private TextLinkService textLinkService;

	@Autowired
	public TextLinkController(TextLinkService textLinkService) {
		this.textLinkService = textLinkService;
	}

	@GetMapping("/textLink")
	public String doGet() {
		return "textLink";
	}

	@PostMapping("textLink")
	public String doPost(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		String result = "";

		result = textLinkService.doLink(str1, str2);

		model.addAttribute("result", result);

		return "textLink.html";
	}
}