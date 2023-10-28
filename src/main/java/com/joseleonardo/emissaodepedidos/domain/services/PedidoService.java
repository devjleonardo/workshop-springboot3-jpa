package com.joseleonardo.emissaodepedidos.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.emissaodepedidos.domain.entities.Pedido;
import com.joseleonardo.emissaodepedidos.domain.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		return pedido.get();
	}
	
}
