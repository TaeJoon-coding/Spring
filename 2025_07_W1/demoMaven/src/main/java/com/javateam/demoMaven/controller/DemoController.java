package com.javateam.demoMaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping
	public String home(Model model) {
		
		model.addAttribute("arg", "Spring Boot");
		return "home"; 
	}

}
