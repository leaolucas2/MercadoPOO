/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Wilson
 */
public class MenuGerente {

    Estoque estoque;
    Relatorio r;

    public MenuGerente(Estoque estoque, Relatorio r) {
        this.estoque = estoque;
        this.r = r;
    }

    public void menu(Estoque estoque, Relatorio r) throws FileNotFoundException, IOException {
        Scanner teclado = new Scanner(System.in);
        String comando;
        Produto p;
        int isbnNovo;
        do {
            
            System.out.print("A para adicionar produto ou R para pedir Relatório ou F para finalizar. \n");
            comando = teclado.next();
            if (comando.equalsIgnoreCase("a")) {
                System.out.print("Digite o ISBN: \n");
                isbnNovo = teclado.nextInt();
                p = estoque.temestoque(isbnNovo);
                if (p != null) {

                    estoque.addproduto(p);
                    estoque.getEstoque();//teste para ver se realmente está incrementando a lista
                } else {
                    System.out.print("Ainda não temos este produto. \n Registre-o, por gentileza!\n");
                    estoque.novoProduto();
                    estoque.getEstoque();//teste
                }
            } else if (comando.equalsIgnoreCase("r")) {
                String linha;
                System.out.println("Relatorio: Digite V para vendas ou E para estoque");
                comando = teclado.next();
                if (comando.equalsIgnoreCase("V")) {

                    FileReader fr = new FileReader(r.getNomeVendas());
                    BufferedReader br = new BufferedReader(fr);
                    while (true) {
                        linha = br.readLine();
                        if (linha != null) {
                            System.out.println(" " + linha);
                        } else {
                            break;
                        }
                    }
                } else if (comando.equalsIgnoreCase("E")) {
                    FileReader fr = new FileReader(r.getNomeEstoque());
                    BufferedReader br = new BufferedReader(fr);

                    while (true) {
                        linha = br.readLine();
                        if (linha != null) {
                            System.out.println(" " + linha);
                        } else {
                            break;
                        }
                    }
                    br.close();
                } else {
                    System.out.println("Comando Inválido! ");
                }
            } else if ((!comando.equalsIgnoreCase("f"))) {

                System.out.println("Comando Inválido! " + comando);

            }
        } while (!comando.equalsIgnoreCase("f"));
    }

}
