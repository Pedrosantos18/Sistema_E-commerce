package entities;

public class ProdutoDigital extends Produto {

    private int tamanhoMb; //Tamanho em MB do produto digital

    // Classe que representa um produto digital, estende Produto
    public ProdutoDigital(int tamanhoMb) {
        this.tamanhoMb = tamanhoMb;
    }

    public ProdutoDigital(String nome, double precoBase, int tamanhoMb) {
        super(nome, precoBase);
        this.tamanhoMb = tamanhoMb;
    }

    public int getTamanhoMb() {
        return tamanhoMb;
    }

    public void setTamanhoMb(int tamanhoMb) {
        this.tamanhoMb = tamanhoMb;
    }

    //Sobescreve o método calcularPreçoFinal para adiconar a taixa fixa de R$2
    @Override
    public double calcularPrecoFinal() {
        return this.getPrecoBase() + 2.00;
    }
}
