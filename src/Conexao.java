import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/jdbc";
    private String name = "root";
    private String password = "Senha@12345";

    public void Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Banco de dados achado com sucesso!");

            Connection conexao = DriverManager.getConnection(url, name, password);
            System.out.println("Conectado ao banco com sucesso!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Banco de dados não encontrado");
        } catch (SQLException e) {
            System.out.println("Erro! Banco de dados não conectado");
        }
    }
}
