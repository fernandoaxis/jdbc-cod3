/*01*/

package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		
		Statement stmt = conexao.createStatement();
		stmt.execute("create database if not exists cod3r");
		
		System.out.println("Banco de dados criado com sucesso");
		conexao.close();
		
	}
}
