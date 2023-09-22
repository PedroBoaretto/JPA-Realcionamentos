package com.example.ac1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.ac1.models.CategoriaProduto;
import com.example.ac1.models.Produto;
import com.example.ac1.repository.CategoriaProdutoRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtosRepository, @Autowired CategoriaProdutoRepository categoriaProdutoRespository){

		return args -> {

			System.out.println("** Inserindo produtos exemplo **");
			produtosRepository.inserir(new Produto((long) 1, "teste", 10));
			produtosRepository.inserir(new Produto((long) 1, "teste2", 10));

			System.out.println("** Exemplo obter todos **");
			List<Produto> listaProdutos = produtosRepository.obterTodos();
			listaProdutos.forEach(System.out::print);

			System.out.println("** Exemplo inserir Categoria **");
            CategoriaProduto c1 = new CategoriaProduto(1, "Doce", "bao deamais");
            categoriaProdutoRespository.inserir(c1);
			System.out.println(c1);

            System.out.println("** Exemplo atualiza Categ Curso **");
            listaProdutos.get(0).setCategoriaProduto(c1);
            produtosRepository.inserir(listaProdutos.get(0));

			System.out.println("** Exemplo obtem por id **");
			Produto produtoPorId = produtosRepository.obterPorId(1);
			System.out.println("Produto econtrado: " + produtoPorId);

			System.out.println("** Exemplo excluir produto**");
            produtosRepository.excluir(1);
			System.out.println(listaProdutos);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
