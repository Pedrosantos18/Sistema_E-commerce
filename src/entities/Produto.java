package entities;

public class Produto {

    private String nome;
    private double precoBase;

    public Produto() {

    }

    public Produto(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public double calcularPrecoFinal() {
        return precoBase;
    }
}
