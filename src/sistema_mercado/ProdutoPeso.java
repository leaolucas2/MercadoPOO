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
public class ProdutoPeso extends Produto {
    
    private float qntd;
    
    public ProdutoPeso(String nome, float preco, int isbn,float qntd){
        super(nome,preco,isbn);
        this.qntd = qntd;
    }
    
   
    public float precoVenda(float peso){
        return  (super.getpreco() * peso);
    }
    
    public void setQntd(float peso){
        this.qntd += peso;
    }
    
    public float getQntd(){
        return this.qntd;
    }
    /*
    outro Polimorfismo
    private float qntd;
    public ProdutoPeso(String nome, float preco, int isbn, float qntd){
        super(nome,preco,isbn);
        this.qntd = qntd;
    }
    
    public void setqntd(float qntd){
        this.qntd = qntd;
    }
    public float getFloatQntd(){
        return this.qntd;
    }
    public int getIntQntd(){
        return -1;
    }
    public double getPrecoPeso(float peso){
        return super.getpreco() * peso;
    }
    */
    
   }
