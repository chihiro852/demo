package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetPostController {
	@GetMapping("/postTemplates")
	public String doGet() {

		return "postTemplates.html";
	}

	@PostMapping("lesson3")
	public String doPost(@RequestParam("post1") String str1, @RequestParam("post2") String str2, Model model) {
		model.addAttribute("str1", str1);
		model.addAttribute("str2", str2);

		return "getPostResult.html";
	}

	@GetMapping("/getPostResult")
	public String doGet(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
		model.addAttribute("str1", str1);
		model.addAttribute("str2", str2);

		return "getPostResult.html";
	}

	// 復習
	// 画面遷移なしでもいける
	@GetMapping("/getPost")
	public String doGet2() {
		return "getPost";
	}

	@PostMapping("post2")
	public String doPost2(@RequestParam("strZenhan") String zenhan, @RequestParam("strKohan") String kohan,
			Model model) {
		model.addAttribute("strZenhan", zenhan);
		model.addAttribute("strKohan", kohan);
		return "getPost";
	}

}