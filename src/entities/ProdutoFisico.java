package entities;

public class ProdutoFisico extends Produto {

    private double peso; //Peso produto em Kg

    // Classe que representa um produto físico, estende Produto
    public ProdutoFisico(String nome, double precoBase, double peso) {
        super(nome, precoBase);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //Sobescreve o método calcularPreçoFinal para incluir o peso
    @Override
    public double calcularPrecoFinal() {
        //Preço final = preço base + R$5 por Kg
        return this.getPrecoBase()+ (this.peso * 5.00);
    }
}
