package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/login")
    public String demo(Model model) {

    	return "login.html";
    }
    
    @GetMapping("/param")
    public String param( Model model ) {
    	model.addAttribute( "message", "中村です" );
    	
    	return "param.html";
    }
}