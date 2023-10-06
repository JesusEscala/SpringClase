package com.ciberfarma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProyectoController {
	// controlador para abrir la pagin login
	// Forma en que se llama al controlador
	// Forma 1. URL/hef --> Get
	@GetMapping("/login")
	public String abrirPagLogin() {
		// acciones
		// dispatcher->la pagina o recurso a redireccionar
		return "login";
	}

	// Forma 2 Formularios -> Post
	@PostMapping("/login")
	public String validarLogin(@RequestParam(name = "txtUsuario") String usuario,
			@RequestParam(name = "txtClave") String clave, Model model)
	{
		// leer los campos del formulario
		//enviar a la pagina un mensaje -> attribute("nom_atrib", valor)
		if(usuario==null | clave==null) {
			model.addAttribute("mensaje", "Error en ingreso de usuario");

			model.addAttribute("cssmensaje2", "alert alert-success");
		}else {
			model.addAttribute("mensaje", "Bienvenido : "+usuario);

			model.addAttribute("cssmensaje", "alert alert-danger");
		}
		return "login";
	}
}
