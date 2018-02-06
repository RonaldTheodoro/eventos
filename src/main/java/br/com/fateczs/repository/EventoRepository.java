package br.com.fateczs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fateczs.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> { }
