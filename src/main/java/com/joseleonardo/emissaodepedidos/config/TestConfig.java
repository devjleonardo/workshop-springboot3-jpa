package com.joseleonardo.emissaodepedidos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joseleonardo.emissaodepedidos.domain.entities.Categoria;
import com.joseleonardo.emissaodepedidos.domain.entities.ItemPedido;
import com.joseleonardo.emissaodepedidos.domain.entities.Pagamento;
import com.joseleonardo.emissaodepedidos.domain.entities.Pedido;
import com.joseleonardo.emissaodepedidos.domain.entities.Produto;
import com.joseleonardo.emissaodepedidos.domain.entities.Usuario;
import com.joseleonardo.emissaodepedidos.domain.entities.enums.StatusPedido;
import com.joseleonardo.emissaodepedidos.domain.repositories.CategoriaRepository;
import com.joseleonardo.emissaodepedidos.domain.repositories.ItemPedidoRepository;
import com.joseleonardo.emissaodepedidos.domain.repositories.PedidoRepository;
import com.joseleonardo.emissaodepedidos.domain.repositories.ProdutoRepository;
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
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Electronics");
		Categoria categoria2 = new Categoria(null, "Books");
		Categoria categoria3 = new Categoria(null, "Computers"); 
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		produto1.addCategoria(categoria2);
		produto2.addCategoria(categoria1);
		produto2.addCategoria(categoria3);
		produto3.addCategoria(categoria3);
		produto4.addCategoria(categoria3);
		produto5.addCategoria(categoria2);

		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		Usuario usuario1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario usuario2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido pedido1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, usuario1);
		Pedido pedido2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario2);
		Pedido pedido3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario1);
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 2, produto1.getPreco());
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 1, produto3.getPreco());
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto3, 2, produto3.getPreco());
		ItemPedido itemPedido4 = new ItemPedido(pedido3, produto5, 2, produto5.getPreco());

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4));
	
		Pagamento pagamento1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), pedido1);
		pedido1.setPagamento(pagamento1);
		
		pedidoRepository.save(pedido1);
	}

}