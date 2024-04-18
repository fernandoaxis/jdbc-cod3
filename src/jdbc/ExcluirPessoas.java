package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoas {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        System.out.println("Informe o código da pessoa que deseja excluir:");
        int codigo = entrada.nextInt();
        
        String sql = "delete from pessoas where codigo = ?";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, codigo);
        
        if (stmt.executeUpdate() > 0) {
            System.out.println("Pessoa excluída com sucesso");
        } else {
            System.out.println("Nada feito");
        }
        
        conexao.close();
        entrada.close();
    }
}