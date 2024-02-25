package com.aprendendo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.curso.entitis.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
