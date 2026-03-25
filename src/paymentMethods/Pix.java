package paymentMethods;

import interfaces.Pagamento;

//Classe responsável por implementar o pagamento via pix

public class Pix implements Pagamento {

    @Override
    public double pagar(double valor) {
        return valor * 0.9;
    }
}
