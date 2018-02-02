package TesteAplicacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import model.Evento;
import model.Usuario;
import model.UsuarioEvento;
import repository.EventoRepository;
import repository.UsuarioRepository;

@SpringBootApplication
@EntityScan(basePackages = { "model" })
@EnableJpaRepositories(basePackages = { "repository" })
public class TesteTudo implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TesteTudo.class);

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public static void main (String [] args) {
		
		SpringApplication.run(TesteTudo.class, args);
		
	}
	
	@Override
	@Transactional
	public void run (String... arg0) {
		Usuario userA = new Usuario(null, "Daniel", "Rua 1", "danielcs1993@hotmail.com", "115599", true);
		usuarioRepository.save(userA);
		System.out.println("Usuario Salvo");
		Evento eventoA = new Evento(null, "", "Evento1", "", "", 12.00);
		UsuarioEvento usuEve = new UsuarioEvento(userA, eventoA);
		
		eventoA.getUsuarioEventos().add(usuEve);
		eventoRepository.save(eventoA);
		System.out.println("Tudo Salvo");
	}

}
