package entities;

import java.util.ArrayList;
import java.util.List;

//Classe que representa o carrinho de compras
public class CarrinhoDeCompras {

    private List<Produto> items;//lista de produtos no carrinho

    public CarrinhoDeCompras() { //Construtor inicializa uma lista vazia
        this.items = new ArrayList<>();
    }

    //Adiciona produto ao carrinho
    public void adicionarProduto(Produto p){
        this.items.add(p);
    }

    //Verifica se o carrinho está vazio
    public boolean estaVazio(){
        return this.items.isEmpty();
    }


    //Remove produto por índice
    public void removerProduto(int index) {
        if (items.isEmpty()) {
            System.out.println("Carrinho está vazio!");
            return;
        }

        if (index >=0 && index < items.size()) {
            Produto removido = items.remove(index);
            System.out.println("Produto removido: " + removido.getNome());
        } else {
            System.out.println("Índice inválido!");
        }
    }

    //Calcula o total do carrinho
    public double calcularTotal() {
        double total = 0;
        for (Produto p : this.items) {
             total += p.calcularPrecoFinal();
        }

        return total;
    }

    //lista no carrinho o produto com índice, nome e preço final
    public void listarProdutos(){
        if (items.isEmpty()) {
            System.out.println("O carrinho está vazio!");
            return;
        }

        System.out.println("\n--- Items no carrinho ---");
        for(int i = 0; i < items.size(); i++) {
            Produto p = items.get(i);
            System.out.printf("%d - %s | R$%.2f%n", i, p.getNome(), p.calcularPrecoFinal());
        }

        System.out.printf("Total da compra: R$%.2f%n", calcularTotal());
    }
}
