package com.javateam.demoMVC.controller;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMVCController {
	
	private static final Logger logger
		= LoggerFactory.getLogger(DemoMVCController.class);
	
	@GetMapping("/")
	public String demo() {
		logger.info("demo log");
		
		return "demo";
	}
	
}
