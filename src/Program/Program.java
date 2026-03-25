package Program;

import entities.CarrinhoDeCompras;
import entities.Produto;
import entities.ProdutoDigital;
import entities.ProdutoFisico;
import interfaces.Pagamento;
import paymentMethods.Boleto;
import paymentMethods.CartaoCredito;
import paymentMethods.Pix;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//Classe principal que roda o programa
public class Program {

    public static void linha() {
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        CarrinhoDeCompras cc = new CarrinhoDeCompras();

        //Criação de catálogo de produtos
        List<Produto> catalogo = new ArrayList<>();
        catalogo.add(new ProdutoFisico("Cadeira Gamer Tyr - preta", 400.0, 10));
        catalogo.add(new ProdutoFisico("Teclado T-Dagger Plus - branca", 250.0, 1));
        catalogo.add(new ProdutoFisico("Mouse Hyperx", 150.0, 0.5));
        catalogo.add(new ProdutoDigital("Game PS5 Black Myth Wukong", 250.0, 105000));
        catalogo.add(new ProdutoDigital("Game PS5 Crison Desert", 350.0, 135000));
        catalogo.add(new ProdutoDigital("Game PS5 EAFC 26", 80.0, 57000));

        System.out.println("===================================");
        System.out.println("Bem vindo ao Sistema de E-commerce");
        System.out.println("===================================");

        int opcao;

      do{
          //Menu principal
          System.out.println("=== MENU PRINCIPAL ===");
          System.out.println("1 - Adicionar Produto");
          System.out.println("2 - Listar Produtos");
          System.out.println("3 - Remover Produto");
          System.out.println("4 - Finalizar compra");
          System.out.println("5 - Sair");
          System.out.print("Escolha: ");

          opcao = sc.nextInt();
          System.out.println();

          switch (opcao) {

              case 1:
                  //Sub-menu para adicionar produtos
                  boolean adicionando = true;
                  while (adicionando) {
                      System.out.println("=== CATÁLOGO ===");

                      for(int i = 0; i < catalogo.size(); i++) {
                          Produto p = catalogo.get(i);
                          System.out.printf("%d - %s | R$%.2f%n", i, p.getNome(), p.calcularPrecoFinal());
                      }
                      System.out.println("-1 - Voltar para o menu principal");

                      linha();
                      System.out.print("Escolha o número do Produto: ");
                      int escolha = sc.nextInt();

                      if (escolha == -1) {
                          adicionando = false;
                      }
                      if (escolha >= 0 && escolha < catalogo.size()) {
                          Produto escolhido = catalogo.get(escolha);
                          cc.adicionarProduto(escolhido);
                          System.out.println("Produto adicionado ao carrinho com sucesso!\n");
                      } else {
                          System.out.println("Opção inválida!\n");
                      }
                  }
                  break;

              case 2:
                  //Listar produtos no carrinho
                  System.out.println();
                  cc.listarProdutos();
                  System.out.println();
                  break;

              case 3:
                  //Remover produtos do carrinho
                  if(cc.estaVazio()) {
                    System.out.println("Carrinho está vazio!\n");
                    break;
                  }

                  cc.listarProdutos(); //mostra índice

                  System.out.print("Digite o número do produto que deseja remover: ");
                  int escolhaRetirar = sc.nextInt();

                  cc.removerProduto(escolhaRetirar);

                  System.out.println();
                  break;

              case 4:
                  //Finaliza a compra e escolha da forma de pagamento
                  if(cc.estaVazio()) {
                      System.out.println("Carrinho está vazio!\n");
                      break;
                  }

                  System.out.println("\n=== PAGAMENTO ===");
                  System.out.println("1 - Pix");
                  System.out.println("2 - Boleto");
                  System.out.println("3 - Cartão de crédito!");

                  int tipo = sc.nextInt();
                  Pagamento pagamento;

                  if (tipo == 1) {
                      pagamento = new Pix();
                      System.out.print("Pagamento no Pix realizada com sucesso!\n");
                  } else if (tipo == 2) {
                      pagamento = new Boleto();
                      System.out.print("Pagamento no Boleto realizada com sucesso!\n");
                  } else if (tipo == 3) {
                      System.out.print("Em quantas parcelas deseja pagar: ");
                      int parcelas = sc.nextInt();
                      pagamento = new CartaoCredito(parcelas);
                      System.out.print("Pagamento no Cartão de Crédito realizada com sucesso!\n");
                  } else {
                      System.out.print("Opção inválida!");
                      break;
                  }

                  double total = cc.calcularTotal();
                  double totalFinal = pagamento.pagar(total);

                  System.out.println("\n-----------------------------------");
                  System.out.printf("Total final : R$%.2f%n", totalFinal);
                  System.out.println("-----------------------------------");
                  break;

              case 5:
                  System.out.println("Saindo...");
                  break;

              default:
                  System.out.println("Opção inválida");
          }

      } while(opcao!=5 );

      sc.close();

    }
}