package com.capirona.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Spring multiples variables @PathVariable.");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Spring @PathVariable");
		model.addAttribute("respuesta", "El valor enviado en el path es: " + texto);
		return "variables/ver";
	}

	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Spring @PathVariable");
		model.addAttribute("respuesta", "El valor enviado en el path es: " + texto + 
				". Y el número es: " + numero + ".");
		return "variables/ver";
	}
}
