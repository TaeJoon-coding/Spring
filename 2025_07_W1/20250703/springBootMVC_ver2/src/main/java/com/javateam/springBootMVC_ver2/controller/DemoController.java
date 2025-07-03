package com.javateam.springBootMVC_ver2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;	//Log4J
//import org.slf4j.Logger;	// SLF4J

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.log4j.log4j2;
import lombok.extern.slf4j.Slf4j;


@Controller		// << Controller >> : これはstereotype (UML)です。
@Slf4j		// Slf4J ログオブジェクト(logger)
// @Log4j2		// Log4j2 ログオブジェクト
// @Log			// Java ログオブジェクト
public class DemoController {
		
		// SLF4J
//		private static final Logger logger
//			= Loggerfactory.getLogger(DemoController.class);
		
		// Log4J
//		private static final Logger logger
//			= LogManager.getLogger();
	
	@GetMapping("/")
	public String demo(Model model, HttpServletRequest request) {
		// Model model		// これがspring式
		// HttpServletRequest request
		
		log.info("Demo Controller です！");
		
		// 引数を生成 : forward移動方式専用(only)引数
		model.addAttribute("java", 21);
		request.setAttribute("spring", "6.1.21");
		
		return "demo";		// つまり、demo.htmlにforward(移動)
		
	}
	
	// 昔のやり方。
	// @RequestMapping("/demo")
	@RequestMapping(value="/demo", method=RequestMethod.GET)
	public ModelAndView demo2(HttpServletRequest req) {
		
		log.info("demo2");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("HTML", 5);
		modelAndView.setViewName("demo2");
		req.setAttribute("CSS", 3);
				
		return modelAndView;
		
	}
	
}

