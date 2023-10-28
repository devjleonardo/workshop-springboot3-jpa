package com.joseleonardo.emissaodepedidos.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.joseleonardo.emissaodepedidos.domain.entities.Usuario;
import com.joseleonardo.emissaodepedidos.domain.repositories.UsuarioRepository;
import com.joseleonardo.emissaodepedidos.domain.services.exceptions.BancoDeDadosException;
import com.joseleonardo.emissaodepedidos.domain.services.exceptions.RecuroNaoEncontradoException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario.orElseThrow(() -> new RecuroNaoEncontradoException(id));
	}
	
	public Usuario inserir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void deletar(Long id) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

		if (usuarioExistente.isPresent()) {
			try {
				usuarioRepository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new BancoDeDadosException(e.getMessage());
			}
		} else {
			throw new RecuroNaoEncontradoException(id);
		}
	}
	
	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		try {
			Usuario usuarioExistente = usuarioRepository.getReferenceById(id);

			atualizarDados(usuarioExistente, usuarioAtualizado);

			return usuarioRepository.save(usuarioExistente);
		} catch (EntityNotFoundException e) {
			throw new RecuroNaoEncontradoException(id);
		}

	}

	private void atualizarDados(Usuario usuarioExistente, Usuario usuarioAtualizado) {
		usuarioExistente.setNome(usuarioAtualizado.getNome());
		usuarioExistente.setEmail(usuarioAtualizado.getEmail());
		usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
	}
	
}
