import DAO.CRUD;
import Model.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CRUD crud = new CRUD();
        crud.createTable();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 5) {
            System.out.println("""
                
                -----Selecione uma opção-----
                1 - Criar produto
                2 - Listar produtos
                3 - Atualizar produto
                4 - Deletar produto
                5 - Sair
                """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.println("Descrição do produto: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Valor do produto:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    crud.create(new Produto(nome, descricao, quantidade, preco));
                    break;

                case 2:
                    List<Produto> produto = crud.read();
                    if (produto.isEmpty()) {
                        System.out.println("Nenhum produto encontrado");
                    }
                    else
                    {
                        produto.forEach(System.out::println);
                    }
                    break;

                case 3:
                    produto = crud.read();
                    produto.forEach(System.out::println);

                    System.out.println("Qual o id do produto que gostaria de atualizar?");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome do produto: ");
                    String nomeUp = scanner.nextLine();

                    System.out.println("Descrição do produto: ");
                    String descricaoUp = scanner.nextLine();

                    System.out.println("Quantidade do produto: ");
                    int quantidadeUp = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Valor do produto:");
                    double precoUp = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produtoUp = new Produto(nomeUp, descricaoUp, quantidadeUp, precoUp);
                    produtoUp.setId(id);

                    crud.update(produtoUp);
                    break;

                case 4:
                    produto = crud.read();
                    produto.forEach(System.out::println);

                    System.out.println("Qual id do produto que gostaria de excluir?");
                    int idDel = scanner.nextInt();
                    scanner.nextLine();

                    crud.delete(idDel);
                    break;

                case 5:
                    System.out.println("___Saindo___");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        scanner.close();
    }
}