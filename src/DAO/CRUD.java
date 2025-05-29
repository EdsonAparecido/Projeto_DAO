package DAO;

import JDBC.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
    //Cria objeto que contem a conexão do DataBase
    Conexao conexao = new Conexao();

    //Metodo que cria uma tabela se ainda não tiver sido criada.
    public void criarTabela() {
        String sql = """
                create table if not exists inventario(
                id int auto_increment Primary Key,
                nome varchar(15) not null,
                descricao Text not null,
                quantidade int not null,
                preco int not null,
                total tinyint unsigned
                );
                """;
        //Conecta ao DataBase, e executa o comando passado
        try(Connection connection = conexao.Conexao();
            Statement statement = connection.createStatement()){
            statement.execute(sql);
            System.out.println("Criado tabela com sucesso!");
        } catch (SQLException erro) {
            System.out.println("!Erro! Não foi possível criar tabela! ERRO: " + erro.getMessage());
        }
    }
}
