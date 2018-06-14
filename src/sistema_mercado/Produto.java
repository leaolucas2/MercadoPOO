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
public abstract class Produto {
    
    private String nome;
    private float preco;
    private int isbn;
   
    
    public Produto (String nome, float preco, int isbn){
        this.nome = nome;
        this.preco = preco;
        this.isbn = isbn;
        
    }
    
    public void setnome (String nome){
        this.nome = nome;
    }
    
    public String getnome (){
        return this.nome;
    }

    public void setpreco (float preco){
        this.preco = preco;
    }
    public float getpreco(){
    return this.preco;
    }

    public void setisbn (int isbn){
        this.isbn = isbn;
    }
    public int getisbn(){
        return this.isbn;
    }
    
    
    
}
