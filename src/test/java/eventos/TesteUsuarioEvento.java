package eventos;

import java.sql.SQLException;
import java.util.List;

import dao.EventoDAO;
import dao.UsuarioDAO;
import dao.UsuarioEventoDAO;
import model.Evento;
import model.Usuario;
import model.UsuarioEvento;

public class TesteUsuarioEvento {
	
	public static void main(String[] args) throws SQLException {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.listar().get(0);
		Evento evento = new EventoDAO().listar().get(1);
		UsuarioEvento usuarioEvento = new UsuarioEvento(usuario, evento);
		
		// Inserir
		UsuarioEventoDAO dao = new UsuarioEventoDAO();
		//dao.inserir(usuarioEvento);
		System.out.println("Gravado");
		
		// Listar
		List<Evento> eventosUsuarioX = dao.listar(usuario);
		System.out.println(eventosUsuarioX);
		
		// Excluir
		//dao.excluir(usuarioEvento);
		                       
		
	}

}
