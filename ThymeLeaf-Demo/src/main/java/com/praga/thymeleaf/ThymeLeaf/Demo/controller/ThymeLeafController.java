package com.praga.thymeleaf.ThymeLeaf.Demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThymeLeafController {
	
	
	@GetMapping("/hello")
	public String getHello(Model model) {
		model.addAttribute("theDate", new Date());
		return "helloworld";
	}

}
