package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Usuario;
import utils.ConexaoDB;

public class UsuarioDAO {
	
	private Connection c;
	
	public UsuarioDAO () {
		this.c = new ConexaoDB().getConnetion();
	}
	
	public void inserir(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (nome, endereco, email, senha, adm) values (?, ?, ?, ?, ?)";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEndereco());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setBoolean(5, usuario.isAdm());
		stmt.execute();
		stmt.close();
	}
	

	public Usuario buscar(Usuario usuario) throws SQLException {
		String sql = "Select * from Usuario where id  = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, usuario.getId());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			usuario = new Usuario(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getBoolean(6));
		}
		return usuario;
	}
	
	
	public List<Usuario> listar() throws SQLException {
		String sql = "Select * from Usuario";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Usuario> listaUsuarios = new ArrayList<>();
		while(rs.next()) {
			Usuario usuario = new Usuario(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getBoolean(6));
			listaUsuarios.add(usuario);
		}
		return listaUsuarios;
	}
	
	public void alterar (Usuario usuario) throws SQLException {
		String sql = "Update Usuario set nome = ?, endereco = ?, email = ?, senha = ?, adm = ? where id = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEndereco());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getSenha());
		stmt.setBoolean(5, usuario.isAdm());
		stmt.setInt(6, usuario.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void excluir(Usuario usuario) throws SQLException {
		String sql = "Delete from Usuario where id = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, usuario.getId());
		stmt.execute();
		stmt.close();
	}

}
