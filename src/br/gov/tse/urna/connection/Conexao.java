package br.gov.tse.urna.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexao {
	
	private static Conexao conexao;
	private static ResourceBundle config;
	
	private Conexao() {
		config = ResourceBundle.getBundle("config");
	}
	public static Conexao getInstance() {
		if(conexao == null) {
			conexao = new Conexao();
		}
		return conexao;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(config.getString("br.gov.tse.urna.postgresql.Driver"));
		return DriverManager.getConnection(config.getString("br.gov.tse.urna.postgresql.Url"), 
				config.getString("br.gov.tse.urna.usuario"), config.getString("br.gov.tse.urna.senha"));
	}
}
