package br.com.fateczs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fateczs.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> { }
