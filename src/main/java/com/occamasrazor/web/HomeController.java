package com.occamasrazor.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootConfiguration
@Controller
public class HomeController {
	@GetMapping("/")
	public String hello() {
		return "index.html";
	}
	@GetMapping("/lotto")
	public String lotto() {
		return "lotto/buy.html";
	}
	
}
