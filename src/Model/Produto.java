package Model;

public class Produto {
    //Propriedades da classe
    private String nome;
    private int quantidade;
    private int preco;

    //Qual propriedade devo passar
    public void Produto(String nome, int quantidade, int preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    //Retorno de nome, quantidade e preço
    public String getNome() {
        return nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public int getPreco() {
        return preco;
    }

    @Override
    public String toString(){
        return String.format("teste");
    }
}
