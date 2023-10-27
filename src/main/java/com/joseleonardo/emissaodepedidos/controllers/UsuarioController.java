package com.joseleonardo.emissaodepedidos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.emissaodepedidos.domain.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<Usuario> listar() {
		Usuario usuario = new Usuario(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		
		return ResponseEntity.ok().body(usuario);
	}
	
}
