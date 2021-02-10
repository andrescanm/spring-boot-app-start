package com.capirona.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app")
public class AppController {
	
	@GetMapping(value = {"", "/", "index", "myApp"})
	public String index(Model model) {
		model.addAttribute("titulo", "Acceso Principal App!");
		return "app";
	}
}
