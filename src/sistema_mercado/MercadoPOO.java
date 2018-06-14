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
public class MercadoPOO {
    
     
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //preenchimento manual
        Estoque e = new Estoque();
        ProdutoUnidade leite = new ProdutoUnidade("Leite",14.00f,1,5);
        ProdutoUnidade sabao = new ProdutoUnidade("Sabao",5.00f,2,10);
        ProdutoUnidade refrigerante = new ProdutoUnidade("Refrigerante",7.00f,3,30);
        ProdutoUnidade suco = new ProdutoUnidade("Suco",10.00f,4,40);
        ProdutoUnidade biscoito = new ProdutoUnidade("Biscoito",5.00f,5,20);
        ProdutoPeso carne = new ProdutoPeso("Carne",10.00f,500,30.00f);
        ProdutoPeso banana = new ProdutoPeso("Banana",2.59f,501,30.00f);
        ProdutoPeso feijao = new ProdutoPeso("Feijão",999.00f,502,10.00f);
        
        e.addproduto(leite);
        e.addproduto(feijao);
        e.addproduto(sabao);
        e.addproduto(banana);
        e.addproduto(carne);
        e.addproduto(suco);
        e.addproduto(refrigerante);
        e.addproduto(biscoito);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Funcionario gerente = new Funcionario(0);
        Funcionario f1 = new Funcionario(1);
        Funcionario f2 = new Funcionario(2);
        Funcionario f3 = new Funcionario(3);
        Funcionario f4 = new Funcionario(4);
        Funcionario f5 = new Funcionario(5);
        funcionarios.add(gerente);
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);
        funcionarios.add(f5);
        ArrayList<Caixa> caixas = new ArrayList<>();
        Caixa c1 = new Caixa(1);
        Caixa c2 = new Caixa(2);
        Caixa c3 = new Caixa(3);
        caixas.add(c1);
        caixas.add(c2);
        caixas.add(c3);
        
        //fim do preenchimento
        //chama nova instância do administrador SistemaMercado;
        
        SistemaMercado mercado = new SistemaMercado(e,funcionarios,caixas);
        mercado.Iniciar(mercado);

    }
    
}
