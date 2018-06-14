/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

/**
 *
 * @author Wilson
 */
public class ProdutoUnidade extends Produto{
    private int qntd;
    
    public ProdutoUnidade(String nome, float preco, int isbn,int qntd){
        super(nome,preco,isbn);
        this.qntd = qntd;
    }
    
    public void setQntd(int qntd){
        this.qntd += qntd;
    }
    
    public int getQntd(){
    return this.qntd;
    }
}
