package TesteAplicacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controller.UsuarioController;
import model.Usuario;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages =  {"controller", "service"})
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan("model")
@EnableAutoConfiguration
public class TesteTudo implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TesteTudo.class);

	public static void main (String [] args) {
		SpringApplication.run(TesteTudo.class, args);
	}
	
	@Autowired
	private UsuarioController cont;
	
	@Override
	public void run (String... arg0) {
		Usuario usuario = new Usuario();
		usuario.setEmail("danielcs1993@hotmail.com");
		usuario.setSenha("115599");
		
		boolean helper = cont.isValidUser(usuario);
		if(usuario !=null) System.out.println(helper);
		
		//Usuario usuario = new Usuario("Daniel", "Rua2", "danielcs1993@hotmail.com", "115599", false);
		//usuarioRepository.save(usuario);
		//System.out.println(usuarioRepository.findOne("danielcs1993@hotmail.com").getEmail());
		//usuarioRepository.findOne("danielcs1993@hotmail.com");
		
		/**
		Usuario userA = new Usuario(null, "Daniel", "Rua 1", "danielcs1993@hotmail.com", "115599", true);
		usuarioRepository.save(userA);
		System.out.println("Usuario Salvo");
		Evento eventoA = new Evento(null, "", "Evento1", "", "", 12.00);
		UsuarioEvento usuEve = new UsuarioEvento(userA, eventoA);
		
		eventoA.getUsuarioEventos().add(usuEve);
		eventoRepository.save(eventoA);
		System.out.println("Tudo Salvo");
	**/
	}

}
