package com.aprendendo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.curso.entitis.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
