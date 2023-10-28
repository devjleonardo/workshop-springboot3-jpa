package com.joseleonardo.emissaodepedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.emissaodepedidos.domain.entities.Produto;
import com.joseleonardo.emissaodepedidos.domain.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar() {
		List<Produto> produtos = produtoService.listar();
		
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);

		return ResponseEntity.ok().body(produto);
	}
	
}
