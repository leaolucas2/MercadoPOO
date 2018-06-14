/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class SistemaMercado {

    Estoque e;
    ArrayList<Funcionario> funcionarios;
    ArrayList<Caixa> caixas;
    Relatorio relatorio;

    public SistemaMercado(Estoque e, ArrayList<Funcionario> funcionarios, ArrayList<Caixa> caixas) throws IOException {
        this.e = e;
        this.funcionarios = funcionarios;
        this.caixas = caixas;

        relatorio = new Relatorio("relatorioVendas.txt", "relatorioEstoque.txt");
        relatorio.addRelatorioEstoque(e,0);
    }

    public void Logar(int id, int caixa, SistemaMercado mercado) throws IOException, InterruptedException {//conecta usuario ao caixa
        Funcionario f = mercado.funcionarios.get(id);
        Caixa c = mercado.caixas.get(caixa);
        c.abre_caixa(f, mercado.e, mercado.relatorio);
    }

    /**
     *
     * @param mercado
     * @throws java.io.IOException
     */
    public void Iniciar(SistemaMercado mercado) throws IOException, InterruptedException {//primeira Tela

        Scanner teclado = new Scanner(System.in);
        int id, caixa;
        boolean fim = false;

        do {
            System.out.print("Bem-vindo!\n");
            System.out.print("Para começar, tecle 0 para login de gerente, 1 para login de funcionário, \n");
            System.out.print("2 para consulta de preco ou -1 para sair: ");
            id = teclado.nextInt();

            if (id == -1) {
                break;// para parar o programa
            } else if (id == 0) {
                MenuGerente gerente = new MenuGerente(e, relatorio);
                gerente.menu(e, relatorio);
            } else if (id == 2) {
                String i;
                int isbn;
                Leitor leitor = new Leitor(e);
                do {
                    
                    System.out.println("Insira o isbn do produto para consulta de preco (-1 para sair): ");
                    i = teclado.next();
                    isbn = Integer.parseInt(i);
                    leitor.mostrar(isbn);
                } while (isbn != -1);
            } else if (id == 1) {
                System.out.print("Insira seu ID(1,2,3,4,5): ");
                id = teclado.nextInt();
                System.out.print("Digite o seu Caixa(0, 1 ou 2): ");
                caixa = teclado.nextInt();
                this.Logar(id, caixa, mercado);
            }
        } while (true);
    }

}
