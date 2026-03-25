package paymentMethods;

import interfaces.Pagamento;

//Classe responsável por implementar oe pagamento via boleto

public class Boleto implements Pagamento {

    @Override
    public double pagar(double valor) {
        return valor * 0.7;
    }
}
