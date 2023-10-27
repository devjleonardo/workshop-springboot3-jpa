package com.joseleonardo.emissaodepedidos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joseleonardo.emissaodepedidos.domain.entities.Usuario;
import com.joseleonardo.emissaodepedidos.domain.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
	}

}
