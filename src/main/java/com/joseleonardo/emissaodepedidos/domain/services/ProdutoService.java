package com.joseleonardo.emissaodepedidos.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.emissaodepedidos.domain.entities.Produto;
import com.joseleonardo.emissaodepedidos.domain.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		return produto.get();
	}

}
