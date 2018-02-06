package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> { }
