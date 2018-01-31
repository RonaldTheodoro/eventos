package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Evento;
import model.Usuario;
import model.UsuarioEvento;
import utils.ConexaoDB;

public class UsuarioEventoDAO {
	
	private Connection c;
	
	public UsuarioEventoDAO() {
		this.c = new ConexaoDB().getConnetion();
	}

	public void inserir (UsuarioEvento usuarioEvento) throws SQLException {
		String sql = "insert into usuario_has_evento (usuario_id, evento_id) values (?, ?)";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, usuarioEvento.getUsuario().getId());
		stmt.setInt(2, usuarioEvento.getEvento().getId());
		stmt.execute();
		stmt.close();
	}
	
	public List<Evento> listar (Usuario usuario) throws SQLException {
		String sql = "select a.* from evento a left join usuario_has_evento  as b " + 
				"on a.id = b.evento_id where b.usuario_id = ? ";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, usuario.getId());
		ResultSet rs = stmt.executeQuery();
		List<Evento> eventos = new ArrayList<>();
		while (rs.next()) {
			Evento evento = new Evento(
					rs.getInt(1), 
					rs.getString(2),
					rs.getString(3), 
					rs.getString(4), 
					rs.getString(5), 
					rs.getDouble(6));
			eventos.add(evento);
		}
		rs.close();
		stmt.close();
		return eventos;
	}
	
	public void alterar (UsuarioEvento usuarioEvento) throws SQLException {
		String sql = "update Usuario_has_evento set comparecimento = ? where usuario_id = ? and evento_id = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setBoolean(1, usuarioEvento.isComparecimento());
		stmt.setInt(2, usuarioEvento.getUsuario().getId());
		stmt.setInt(3, usuarioEvento.getEvento().getId());
		stmt.execute();
		stmt.close();
	}
	
	public void excluir(UsuarioEvento usuarioEvento) throws SQLException {
		String sql = "delete from usuario_has_evento where usuario_id = ? and evento_id = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, usuarioEvento.getUsuario().getId());
		stmt.setInt(2, usuarioEvento.getEvento().getId());
		stmt.execute();
		stmt.close();
	}
}
