package com.aprendendo.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.aprendendo.curso.entitis.Categoria;
import com.aprendendo.curso.entitis.Pagamento;
import com.aprendendo.curso.entitis.Pedido;
import com.aprendendo.curso.entitis.PedidoItem;
import com.aprendendo.curso.entitis.Produto;
import com.aprendendo.curso.entitis.Usuario;
import com.aprendendo.curso.entitis.enuns.PedidoStatus;
import com.aprendendo.curso.repositories.CategoriaRepository;
import com.aprendendo.curso.repositories.PedidoItemRepository;
import com.aprendendo.curso.repositories.PedidoRepository;
import com.aprendendo.curso.repositories.ProdutoRepository;
import com.aprendendo.curso.repositories.UsuarioRepository;

@Configuration
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Eletronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "computers");

		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

		pr1.getCategorias().add(cat2);
		pr2.getCategorias().add(cat1);
		pr2.getCategorias().add(cat3);
		pr3.getCategorias().add(cat3);
		pr4.getCategorias().add(cat3);
		pr5.getCategorias().add(cat2);

		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

		Usuario u1 = new Usuario(null, "maria bobagem", "maria@gmail.com", "998997883", "12346");
		Usuario u2 = new Usuario(null, "lucas bobagem", "lucas@gmail.com", "99562530", "123");

		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAID, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2018-06-20T19:53:07Z"), PedidoStatus.PAID, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2017-06-20T19:53:07Z"), PedidoStatus.DELIVERED, u1);

		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

		PedidoItem oi1 = new PedidoItem(p1, pr1, 2, pr1.getPrice());
		PedidoItem oi2 = new PedidoItem(p1, pr3, 1, pr4.getPrice());
		PedidoItem oi3 = new PedidoItem(p3, pr3, 2, pr1.getPrice());
		PedidoItem oi4 = new PedidoItem(p3, pr5, 2, pr5.getPrice());

		pedidoItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T19:53:07Z"), p1);
		p1.setPagamento(pag1);

		pedidoRepository.save(p1);

	}
}
