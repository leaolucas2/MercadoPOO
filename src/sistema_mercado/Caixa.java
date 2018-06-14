/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Wilson
 */
public class Caixa {

    private float venda_total;
    private Funcionario funcionario;
    private Produto produto;
    private int id;

    public Caixa(int id) {
        this.id = id;
    }

    public void abre_caixa(Funcionario funcionario, Estoque e, Relatorio r) throws IOException, InterruptedException {
        String comando;
        Scanner teclado = new Scanner(System.in);

        this.venda_total = 0;
        this.funcionario = funcionario;

        do {
            nova_venda(e, r);//ja começa a venda
            System.out.print("Deseja fazer uma nova venda?(S/N) ");
            comando = teclado.next();
            if (comando.equalsIgnoreCase("N")) {
                System.out.println("\n");
                break;
            }
        } while (true);

    }

    public void nova_venda(Estoque estoque, Relatorio r) {

        Cupons cf = new Cupons();
        Scanner teclado = new Scanner(System.in);
        String comando;
        float peso = 0.0f;
        do {
            System.out.println("Entre com produto (isbn) ou F para finalizar venda.");
            comando = teclado.next();
            if (!comando.equalsIgnoreCase("f")) {
                int isbn = Integer.parseInt(comando);
                produto = estoque.temestoque(isbn);
                if (produto != null) {
                    //System.out.print(isbn);
                    if (produto.getisbn() / 100 >= 5) { // codigo de barra por peso
                        System.out.println("Quantidade(kg): ");
                        float pesos = teclado.nextFloat();
                        //peso = (float) pesos;
                        estoque.decrementaEstoque(produto, (float) pesos);
                        //estoque.getEstoque();
                        cf.addProdutoPeso(produto, (float) pesos);
                    } else {
                        estoque.decrementaEstoque(produto);
                        //estoque.getEstoque();
                        cf.addproduto(produto);
                    }
                }//se não tiver no estoque??
            }
            cf.imprimeCF();
        } while (!comando.equalsIgnoreCase("f"));
        this.venda_total += cf.valortotal();
        cf.setFuncionario(funcionario);
        cf.setCaixa(id);
        try {
            pagamentoForma(cf);
        } catch (InterruptedException e) {
            System.out.println("Erro na Thread de pagamento");
        }
        try {
            r.addRelatorioVendas(cf);
            r.addRelatorioEstoque(estoque, 1);
        } catch (IOException e) {
            System.out.println("Erro ao escrever em arquivo ");
        }
    }

    public void pagamentoForma(Cupons cf) throws InterruptedException {
        //float valor = cf.valortotal();
        String k;
        Scanner kb = new Scanner(System.in);

        do {
            System.out.println("\n Total: R$ " + this.venda_total);
            System.out.println("Forma de pagamento(c - cartão /d - dinheiro): ");
            k = kb.next();
            if (k.equalsIgnoreCase("d")) {
                System.out.println("Dinheiro(valor R$): ");
                float valorDinheiro;
                valorDinheiro = kb.nextFloat();
                System.out.println("Troco: " + (valorDinheiro - cf.valortotal()));
                break;
            } else if (k.equalsIgnoreCase("c")) {
                System.out.println("Insira o Cartão(true/false): ");
                boolean valido;
                valido = kb.nextBoolean();
                if (valido) {
                    Thread.sleep(5000);
                    System.out.println("Transação Autorizada ");
                    break;
                } else {
                    Thread.sleep(5000);
                    System.out.println("Transação Não Autorizada ");
                }
            } else {
                System.out.println("Opção inválida! ");
            }
        } while (true);
    }

}
