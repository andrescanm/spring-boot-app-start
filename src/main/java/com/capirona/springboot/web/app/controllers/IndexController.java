package com.capirona.springboot.web.app.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.capirona.springboot.web.app.models.Usuario;

@Controller
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	private LocalDate localDate = LocalDate.now();
	
	@GetMapping({"/", "index", "home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		model.addAttribute("fecha", "Copyright © - " + localDate);
		return "index";
	}

	@GetMapping({"/profile", "app/profile"})
	public String profile(Model model) {
		model.addAttribute("titulo", textoPerfil);
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Cañón");
		//usuario.setEmail("andres.co@hotmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("fecha", "Copyright © - " + localDate);
		return "profile";
	}
	
	@GetMapping({"app/list"})
	public String list(Model model) {
		model.addAttribute("titulo", textoListar);
		//List<Usuario> usuarios = new ArrayList<>();
		//usuarios.add(new Usuario("Andrés", "Cañón", "andres.co@hotmail.com"));
		//usuarios.add(new Usuario("Freddy", "Krueger", "nightmare@mail.com"));
		//usuarios.add(new Usuario("Saint", "Seiya", "knight@mail.com"));
		//model.addAttribute("usuarios", usuarios);
		model.addAttribute("fecha", "Copyright © - " + localDate);
		return "list";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Andrés", "Cañón", "andres.co@hotmail.com"),
				new Usuario("Freddy", "Krueger", "nightmare@mail.com"),
				new Usuario("Saint", "Seiya", "knight@mail.com")
				);
		return usuarios;
	}
}