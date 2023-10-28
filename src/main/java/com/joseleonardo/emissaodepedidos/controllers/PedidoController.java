package com.joseleonardo.emissaodepedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.emissaodepedidos.domain.entities.Pedido;
import com.joseleonardo.emissaodepedidos.domain.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {
		List<Pedido> pedidos = pedidoService.listar();

		return ResponseEntity.ok().body(pedidos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscarPorId(id);

		return ResponseEntity.ok().body(pedido);
	}

}
