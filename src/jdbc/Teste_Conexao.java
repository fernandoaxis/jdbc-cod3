package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste_Conexao {
	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql://127.0.0.1?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String senha = "12345678";
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		
		System.out.println("Conexao efetuada com sucesso");
		conexao.close();
		
	}
}
