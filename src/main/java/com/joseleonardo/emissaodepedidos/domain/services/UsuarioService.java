package com.joseleonardo.emissaodepedidos.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.emissaodepedidos.domain.entities.Usuario;
import com.joseleonardo.emissaodepedidos.domain.repositories.UsuarioRepository;
import com.joseleonardo.emissaodepedidos.domain.services.exceptions.RecuroNaoEncontradoException;

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
		usuarioRepository.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		Usuario usuarioExistente = usuarioRepository.getReferenceById(id);
		
		atualizarDados(usuarioExistente, usuarioAtualizado);
		
		return usuarioRepository.save(usuarioExistente);
	}

	private void atualizarDados(Usuario usuarioExistente, Usuario usuarioAtualizado) {
		usuarioExistente.setNome(usuarioAtualizado.getNome());
		usuarioExistente.setEmail(usuarioAtualizado.getEmail());
		usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
	}
	
}
