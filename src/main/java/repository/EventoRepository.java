package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
