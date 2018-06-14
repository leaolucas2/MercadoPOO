/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_mercado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author Wilson
 */
public class Relatorio {
    private String nomeVendas;
    private String nomeEstoque;
    FileWriter relatorioVendas;
    FileWriter relatorioEstoque;
    PrintWriter pw;
     
    public Relatorio(String nomeVendas,String nomeEstoque) throws IOException{
        this.nomeVendas = nomeVendas;
        this.nomeEstoque = nomeEstoque;
        try{
        this.relatorioVendas = new FileWriter(nomeVendas, true);
        this.relatorioEstoque = new FileWriter(nomeEstoque, true);
        
        this.pw= new PrintWriter(relatorioVendas);
        }catch(IOException e){
            System.err.print(e + " ERRO ao criar o arquivo");
        }
    }
    
    public String getNomeVendas(){
        return this.nomeVendas;
    }
    public String getNomeEstoque(){
        return nomeEstoque;
    }
    
    public void addRelatorioVendas(Cupons cf) throws IOException{
        ArrayList<Produto> prodCup = cf.getProdutos();
        BufferedWriter bw = new BufferedWriter(new FileWriter(nomeVendas, true));
       
        for(Produto p : prodCup){
            if(p instanceof ProdutoUnidade){
                ProdutoUnidade pu = (ProdutoUnidade) p;
                bw.append("\n ISBN: " + p.getisbn() + " Produto: " + p.getnome() +" Valor: "+ p.getpreco()*pu.getQntd());
            } else{
                ProdutoPeso pp = (ProdutoPeso) p;
                bw.append("\n ISBN: " + p.getisbn() + " Produto: " + p.getnome() +" Valor: "+ p.getpreco()*pp.getQntd());
            }
            
        }
        bw.append("\r\n \n Total das compras: R$"+ cf.valortotal() + "  Funcionario:  "+ cf.getFuncionario().getID() + 
              " Caixa: "+ cf.getCaixa()+"\n -----------------------------\n");
        
        bw.close();
        
    }
    
    public void addRelatorioEstoque(Estoque e, int i) throws IOException{
        ArrayList<Produto> estoque = e.getLProdutos();
        BufferedWriter bw = new BufferedWriter(new FileWriter(nomeEstoque, true));
        ProdutoUnidade pu;
        ProdutoPeso pp;
        if (i == 0)
            bw.append("ESTOQUE INICIAL: \r\n --------------------\r\n");
        for(Produto p : estoque){
            if(p instanceof ProdutoUnidade){
                pu = (ProdutoUnidade) p;
                bw.append("ISBN: " + p.getisbn() + "\r\nProduto: " + p.getnome() + "\r\nValor: " + p.getpreco()
                        + "\r\nQntd.: " + pu.getQntd()+ "\r\n --------------------\r\n");
            }else{
                pp = (ProdutoPeso) p ;
                bw.append("ISBN: " + p.getisbn()+"\r\nProduto: "+p.getnome() + "\r\nValor/kg: "+p.getpreco()+
                        "\r\nQntd.: "+pp.getQntd()+ "\r\n --------------------\r\n");
                
            }
        }
        if (i==0)
            bw.append("ESTOQUE: \r\n --------------------\r\n");
        bw.close();
    }
}
