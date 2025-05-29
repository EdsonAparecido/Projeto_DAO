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
                nome varchar(15) unique not null,
                descricao Text not null,
                quantidade tinyint not null,
                preco double not null,
                total double unsigned
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
                )values(?, ?, ?, ?, ?);
                """;
        try(Connection connection = conexao.Conexao();
            PreparedStatement pStatement = connection.prepareStatement(sql)){
            pStatement.setString(1, produto.getNome());
            pStatement.setString(2, produto.getDescricao());
            pStatement.setInt(3,produto.getQuantidade());
            pStatement.setDouble(4,produto.getPreco());
            pStatement.setDouble(5,produto.getTotal());
            pStatement.executeUpdate();

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
                int idGerado = result.getInt("id");
                produto.setId(idGerado);
                produtos.add(produto);
            }
        } catch (SQLException erro) {
            System.out.println("!ERRO! Não foi possível listar a tabela! ERRO: " + erro.getMessage());
        }
        return produtos;
    }

    public void update(Produto produto){
        String sql = """
                update inventario set nome = ?, descricao = ?, quantidade = ?, preco = ?, total = ? where id = ?;
                """;
        try(Connection connection = conexao.Conexao();
            PreparedStatement pStatement = connection.prepareStatement(sql)){
                pStatement.setString(1, produto.getNome());
                pStatement.setString(2, produto.getDescricao());
                pStatement.setInt(3,produto.getQuantidade());
                pStatement.setDouble(4,produto.getPreco());
                pStatement.setDouble(5,produto.getTotal());
                pStatement.setInt(6, produto.getId());

                pStatement.executeUpdate();
                System.out.println("Realizado update dos dados com sucesso!");
        } catch (SQLException erro) {
            System.out.println("!ERRO! Não foi possível estar dando update nos dados! ERRO: " + erro.getMessage());
        }
    }
}
