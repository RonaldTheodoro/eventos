package eventos;

import java.sql.SQLException;
import java.util.List;

import dao.EventoDAO;
import model.Evento;

public class TesteEvento {
	
	public static void main(String[] args) throws SQLException {
		EventoDAO dao = new EventoDAO();
		// Teste inserir
		Evento evento = new Evento();
		evento.setCategoria("Ação Social - Atlética Fatec Zona Sul");
		evento.setNome("Pantera's Day");
		evento.setDescricao("Doação de Sangue!");
		evento.setDataEvento("08/03/2018");
		evento.setLocal("Fatec Zona Sul");
		evento.setNomePalestrante("Atlética Fatec Zona Sul");
		evento.setCargaHoraria(1.00);
		dao.inserir(evento);
		System.out.println("Gravado!");
		
		// Teste Listar
		List<Evento> eventos = dao.listar();
		System.out.println(eventos);
		
		// Teste alterar
		Evento eventoAlterar = eventos.get(0);
		eventoAlterar.setNome("Panterinha do Mal");
		eventoAlterar.setDataEvento("02/04/2020");
		dao.alterar(eventoAlterar);
		System.out.println("Alterado!");
		
		// Teste buscar por id
		System.out.println(dao.buscar(eventoAlterar));
		
		// TEste Excluir
		//dao.excluir(eventoAlterar);
		//System.out.println("Excluido!");
		
		//Evento evExcluir = new Evento();
		//evExcluir.setId(1);
		//dao.excluir(evExcluir);
	}

}
