package DAO;

import JDBC.Conexao;
import Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    //Cria objeto que contem a conexão do DataBase
    Conexao conexao = new Conexao();

    //Metodo que cria uma tabela se ainda não tiver sido criada.
    public void createTable() {
        String sql = """
                create table if not exists inventario(
                id int auto_increment Primary Key,
                nome varchar(15) not null,
                descricao Text not null,
                quantidade int not null,
                preco double not null,
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

    public void create(Produto produto){
        String sql = """
                insert into inventario(
                nome,
                descricao,
                quantidade,
                preco,
                total
                )values(?, ?, ?, ?, ?)
                """;
        try(Connection connection = conexao.Conexao();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setInt(3,produto.getQuantidade());
            statement.setDouble(4,produto.getPreco());
            statement.setDouble(5,produto.getTotal());
            statement.executeUpdate();
            System.out.println("Adicionado os dados às colunas com sucesso!");
        } catch (SQLException erro) {
            System.out.println("!Erro! Não foi possível adicionar os dados às colunas! ERRO: " + erro.getMessage());
        }
    }

    public List<Produto> read() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "Select * from inventario";

        try(Connection connection = conexao.Conexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql)){
            while (result.next()){
                Produto produto = new Produto(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("descricao"),
                        result.getInt("quantidade"),
                        result.getDouble("preco"),
                        result.getDouble("total")
                        );
            produtos.add(produto);
            }
        } catch (SQLException erro) {
            System.out.println("!ERRO! Não foi possível listar a tabela! ERRO: " + erro.getMessage());
        }
        return produtos;
    }
}
