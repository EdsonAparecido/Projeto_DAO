package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //Propriedades da classe
    private String url = "jdbc:mysql://localhost:3306/jdbc";
    private String name = "root";
    private String password = "Senha@12345";

    //Conexão para se conectar ao DataBase, retorna ao CRUD.
    public Connection Conexao() throws SQLException {
        Connection connection = DriverManager.getConnection(url, name, password);
        return connection;
    }

    //Conexão para testar o banco de dados, se está funcionando corretamente.
    public void TestarConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Banco de dados achado com sucesso!");

            Connection connection = DriverManager.getConnection(url, name, password);
            System.out.println("Conectado ao banco com sucesso!");
        } catch (ClassNotFoundException ex) {
            System.out.println("!ERRO! Banco de dados não encontrado!");
        } catch (SQLException e) {
            System.out.println("!ERRO! Banco de dados não conectado!");
        }
    }
}
