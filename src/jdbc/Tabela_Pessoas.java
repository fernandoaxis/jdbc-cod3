package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tabela_Pessoas {
    public static void main(String[] args) throws SQLException {
        Connection conexao = FabricaConexao.getConexao();
        Statement stmt = conexao.createStatement();
        
        String sql = "create table if not exists pessoas("
                + "codigo int auto_increment primary key,"
                + "nome varchar(80) not null"
                + ")";
        stmt.execute(sql);
        
        System.out.println("Tabela criada com sucesso");
        
        conexao.close();
    }
}