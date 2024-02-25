package com.aprendendo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.curso.entitis.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
