package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Evento;
import utils.ConexaoDB;

public class EventoDAO {
	
	private Connection c;
	
	public EventoDAO () {
		this.c = new ConexaoDB().getConnetion();
	}
	
	public void inserir(Evento evento) throws SQLException {
		String sql = "insert into evento (categoria, nome, descricao, nomePalestrante, cargaHoraria, dataEvento, local) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setString(1, evento.getCategoria());
		stmt.setString(2, evento.getNome());
		stmt.setString(3, evento.getDescricao());
		stmt.setString(4, evento.getNomePalestrante());
		stmt.setDouble(5, evento.getCargaHoraria());
		stmt.setString(6, evento.getDataEvento());
		stmt.setString(7, evento.getLocal());
		stmt.execute();
		stmt.close();
	}
	
	public List<Evento> listar () throws SQLException {
		String sql = "Select * from Evento ";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Evento> eventos = new ArrayList<>();
		while(rs.next()) {
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
	
	public Evento buscar (Evento evento) throws SQLException {
		String sql = "Select * from evento where id = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, evento.getId());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			evento.setId(rs.getInt(1));
			evento.setCategoria(rs.getString(2));
			evento.setNome(rs.getString(3));
			evento.setDescricao(rs.getString(4));
			evento.setNomePalestrante(rs.getString(5));
			evento.setCargaHoraria(rs.getDouble(6));
			evento.setDataEvento(rs.getString(7));
			evento.setLocal(rs.getString(8));
		}		
		rs.close();
		stmt.close();
		return evento;
	}
	
	public void alterar (Evento evento) throws SQLException {
		String sql = "update evento set categoria = ?, nome = ?, descricao = ?, nomePalestrante = ?, cargaHoraria = ?,  dataEvento = ?, local = ? where id = ?";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setString(1, evento.getCategoria());
		stmt.setString(2, evento.getNome());
		stmt.setString(3, evento.getDescricao());
		stmt.setString(4, evento.getNomePalestrante());
		stmt.setDouble(5, evento.getCargaHoraria());
		stmt.setString(6, evento.getDataEvento());
		stmt.setString(7, evento.getLocal());
		stmt.setInt(8, evento.getId());
		stmt.execute();
		stmt.close();	
	}
	
	public void excluir(Evento evento) throws SQLException {
		String sql = "delete from evento where id = ? ";
		PreparedStatement stmt = (PreparedStatement) this.c.prepareStatement(sql);
		stmt.setInt(1, evento.getId());
		stmt.execute();
		stmt.close();	
	}

}
