package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	private String URL_DB = "localhost/eventos";
	private String USUARIO_DB = "root";
	private String SENHA_DB = "admin";
	
	public Connection getConnetion() {
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://" + URL_DB, USUARIO_DB, SENHA_DB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return connection;
	}

}
