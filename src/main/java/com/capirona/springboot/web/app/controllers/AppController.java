package com.capirona.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app")
public class AppController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String tituloIndex;
	
	@GetMapping(value = {"", "/", "index", "myApp"})
	public String index(Model model) {
		model.addAttribute("titulo", tituloIndex);
		return "app";
	}
}
