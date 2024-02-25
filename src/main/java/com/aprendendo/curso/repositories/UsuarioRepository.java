package com.aprendendo.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aprendendo.curso.entitis.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
