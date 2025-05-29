package Model;

public class Produto {
    //Propriedades da classe
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private double total;

    //Qual propriedade devo passar
    public Produto(String nome, String descricao, int quantidade, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Produto(int id, String nome, String descricao, int quantidade, double preco, double total){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.total = total;
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
    public int getId(){
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return String.format("ID: %d NOME:%s DESCRIÇÃO:%s QUANTIDADE:%d PREÇO:¨%f TOTAL:%f", id, nome, descricao, quantidade, preco, total);
    }
}
