/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

import java.util.ArrayList;

/**
 *
 * @author Iuri
 */
public class Leitor {
    Estoque e;
    
    public Leitor(Estoque e){
        this.e = e;
    }
    
    public void atualiza(Estoque e){
        this.e = e;
    }
    public void mostrar(int isbn){
        ArrayList<Produto> list = e.getLProdutos();
        boolean produto_encontrado = false;
        for(Produto p : list){
            if(p.getisbn() == isbn){
                System.out.println("Nome: " + p.getnome());
                if(p instanceof ProdutoUnidade){
                    ProdutoUnidade pu = (ProdutoUnidade) p;
                    System.out.println("Preço: R$"+ pu.getpreco());
                    produto_encontrado = true;
                    break;
                }else{
                    ProdutoPeso pp = (ProdutoPeso) p;
                    System.out.println("Preço: R$"+ pp.getpreco()+ " o Kg");
                    produto_encontrado = true;
                    break;
                }
               
            }
        }
        if (!produto_encontrado){
            System.out.println("Produto não cadastrado!");
        }
    }
}
