import DAO.CRUD;
import Model.Produto;

import java.util.List;

public class Main {
    public static void main(String[] args){
       Produto produto = new Produto("Caneta azul", "Caneta simples que escreve na cor azul", 20, 6.80);
        CRUD crud = new CRUD();
//        crud.createTable();
//        crud.create(produto);

        List<Produto> tabela = crud.read();
        tabela.forEach(System.out::println);

        crud.delete(1);

    }
}