package com.joseleonardo.emissaodepedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.emissaodepedidos.domain.entities.Categoria;
import com.joseleonardo.emissaodepedidos.domain.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categorias = categoriaService.listar();

		return ResponseEntity.ok().body(categorias);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
		Categoria categoria = categoriaService.buscarPorId(id);

		return ResponseEntity.ok().body(categoria);
	}

}
