package eventos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import model.Evento;
import model.Usuario;

public class TesteUsuario {
	
	public static void main (String [] args) throws SQLException, ClassNotFoundException {
		Usuario usuario = new Usuario();
		usuario.setNome("Rafael");
		Evento ev = new Evento();
		ev.setNome("teste1");
		List<Evento> lEv = new ArrayList<>();
		lEv.add(ev);
		usuario.setEventos(lEv);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inserir(usuario);
		System.out.println("Gravado!");

		List<Usuario> usuarios =  usuarioDAO.listar();
		for(Usuario user : usuarios) {
			System.out.println(user.getId() + " - " + user.getNome());
		}
		
		Usuario userAlterar = usuarios.get(0);
		userAlterar.setNome("Joao");
		usuarioDAO.alterar(userAlterar);
		System.out.println("Alterado!");
		System.out.println(usuarioDAO.buscar(userAlterar).getNome());
		System.out.println("Consultado!");
		
		//usuarioDAO.excluir(userAlterar);
		//System.out.println("Excluido!");
		
		
	}
}
