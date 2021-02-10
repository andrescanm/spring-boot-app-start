package com.capirona.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParams {
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Generar href con URL/GET.");
		return "/params/index";
	}
	
	@GetMapping("/string")
	public String params(@RequestParam(name="texto", required = false) String texto, Model model) {
		model.addAttribute("titulo", "Prueba parámetros HTTP/GET.");
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String params(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("titulo", "Prueba parámetros mixtos HTTP/GET.");
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' - El número enviado es: '" + numero + "'.");
		return "params/ver";
	}

	@GetMapping("/mix-params-HttpServletRequest")
	public String params(HttpServletRequest request, Model model) {
		model.addAttribute("titulo", "Prueba parámetros mixtos HTTP/GET.");
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' - El número enviado es: '" + numero + "'.");
		return "params/ver";
	}
}
