package com.joseleonardo.emissaodepedidos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joseleonardo.emissaodepedidos.domain.entities.Categoria;
import com.joseleonardo.emissaodepedidos.domain.entities.Pedido;
import com.joseleonardo.emissaodepedidos.domain.entities.Usuario;
import com.joseleonardo.emissaodepedidos.domain.entities.enums.StatusPedido;
import com.joseleonardo.emissaodepedidos.domain.repositories.CategoriaRepository;
import com.joseleonardo.emissaodepedidos.domain.repositories.PedidoRepository;
import com.joseleonardo.emissaodepedidos.domain.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Electronics");
		Categoria categoria2 = new Categoria(null, "Books");
		Categoria categoria3 = new Categoria(null, "Computers"); 

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario1);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
	}

}
