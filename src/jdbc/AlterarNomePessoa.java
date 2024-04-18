package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.dominio.Pessoa;

public class AlterarNomePessoa {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();
        
        System.out.println("Informe o código da pessoa:");
        int codigo = entrada.nextInt();
        
        String selectSql = "select codigo, nome from pessoas where codigo = ?";
        String updateSql = "update pessoas set nome = ? where codigo = ?";

        PreparedStatement selectStmt = conexao.prepareStatement(selectSql);
        selectStmt.setInt(1, codigo);
        ResultSet rs = selectStmt.executeQuery();
        
        if (rs.next()) {
            Pessoa p = new Pessoa(rs.getInt(1), rs.getString(2));
            System.out.println("O nome atual é " + p.getNome());
            entrada.nextLine(); 
            
            System.out.println("Informe um novo nome:");
            String novoNome = entrada.nextLine();
            
            PreparedStatement updateStmt = conexao.prepareStatement(updateSql);
            updateStmt.setString(1, novoNome);
            updateStmt.setInt(2, codigo);
            updateStmt.executeUpdate();
            
            System.out.println("Pessoa alterada com sucesso");
            
            updateStmt.close();
        } else {
            System.out.println("Pessoa não encontrada");
        }
        
        selectStmt.close();
        conexao.close();
        entrada.close();
    }
}