/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

import java.util.*;

/**
 *
 * @author Wilson
 */
public class Cupons {

    private ArrayList<Produto> produto = new ArrayList<Produto>();
    private Funcionario funcionario;
    private int n_caixa;

    public void addproduto(Produto prod) {
        ProdutoUnidade pu = (ProdutoUnidade) prod;
        pu.setQntd(-pu.getQntd() + 1);
        produto.add(pu);

    }

    public void addProdutoPeso(Produto prod, float peso) {
        ProdutoPeso pp = (ProdutoPeso) prod;
        pp.setQntd(-pp.getQntd() + peso);
        produto.add(pp);
    }

    public float valortotal() {
        float total = 0;
        for (Produto produtos : produto) {
            if (produtos.getisbn() / 100 >= 5) {
                ProdutoPeso pp = (ProdutoPeso) produtos;
                total += pp.precoVenda(pp.getQntd());

            } else {
                total += produtos.getpreco();
            }
        }
        return total;
    }

    public void imprimeCF() {
        ProdutoUnidade pu;
        ProdutoPeso pp;
        for (Produto p : this.produto) {
            if (p instanceof ProdutoUnidade) {
                pu = (ProdutoUnidade) p;
                System.out.print("PRODUTO: " + p.getnome() + " R$" + p.getpreco() + " Qntd: " + pu.getQntd() + "---> "+ pu.getQntd()*p.getpreco()+"\n");
            } else {
                pp = (ProdutoPeso) p;
                System.out.print("Produto: " + p.getnome() + " R$" + p.getpreco() + " Qntd: " + pp.getQntd() + "---> "+ pp.getQntd()*p.getpreco()+"\n");
            }
        }
        System.out.print("Subtotal: R$" + valortotal() + "\n");
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public int getCaixa() {
        return n_caixa;
    }

    public ArrayList<Produto> getProdutos() {
        return produto;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public void setCaixa (int n_caixa){
        this.n_caixa = n_caixa;
    }

}
