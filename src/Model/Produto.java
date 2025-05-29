package Model;

public class Produto {
    //Propriedades da classe
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private int total;

    //Qual propriedade devo passar
    public Produto(String nome, String descricao, int quantidade, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    //Retorno de nome, quantidade e preço
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public double getTotal() {
        return preco * quantidade;
    }

    @Override
    public String toString(){
        return String.format("teste");
    }
}
