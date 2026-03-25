package paymentMethods;

import interfaces.Pagamento;

import java.util.Scanner;

//Classe responsável por implementar o pagamento via cartão de crédito

public class CartaoCredito implements Pagamento {

    private int parcelas;

    public CartaoCredito(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public double pagar(double valor) {

        if (parcelas <= 0) {
            System.out.println("Número de parcelas inválido!");
            return valor;
        }

        //Parcelas até 4x sem juros
        if (parcelas <= 4) {
            double valorParcela = valor/parcelas;
            System.out.printf("%d de R$%.2f (sem juros)", parcelas, valorParcela);
            return valor;
        }

        //Parcelas de 5x até 12x com juros
        else if (parcelas <= 12) {
            double taxa = 0.02 * parcelas;
            double totalComJuros = valor * (1 + taxa);

            double valorParcela = totalComJuros / parcelas;

            System.out.printf("%dx de R$%.2f (sem juros)", parcelas, valorParcela);
            return totalComJuros;
        }

        else {
            System.out.println("Não é possível parcelar em mais de 12x!");
            return valor;
        }
    }
}
