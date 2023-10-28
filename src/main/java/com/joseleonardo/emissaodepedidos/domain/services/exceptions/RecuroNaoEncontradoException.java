package com.joseleonardo.emissaodepedidos.domain.services.exceptions;

public class RecuroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecuroNaoEncontradoException(Object id) {
		super("Recurso não encontrado para o id " + id);
	}

}
