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
public class Estoque {
    
    private ArrayList<Produto> l_produto = new ArrayList<Produto>();
    
    public void addproduto(Produto produto){

        int index = l_produto.indexOf(produto);// verificação redundante
        if (index>=0){
            
            if(l_produto.get(index) instanceof ProdutoUnidade){
                ProdutoUnidade pu = (ProdutoUnidade) l_produto.get(index);
                pu.setQntd(1);
                l_produto.add(index,pu);
            }else{
                float adicional;
                Scanner teclado = new Scanner(System.in);
                System.out.println("Digite a Quantidade para adicionar: ");
                adicional = teclado.nextFloat();
                ProdutoPeso pp = (ProdutoPeso) l_produto.get(index);
                pp.setQntd(adicional);
                l_produto.add(index,pp);
            }
            
           // l_produto.add(index, p);
        }
        else{
            l_produto.add(produto);
        }
    }
    
    public void novoProduto(){
        
        String nome;
        int isbn;
        float qntd;
        float preco;
        Scanner tecladonome = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o ISBN: \n");
        isbn = teclado.nextInt();
//        System.out.println("");
        if((isbn / 100) >= 5){
            ProdutoPeso pp;
            System.out.print("Digite o nome: ");
            nome = tecladonome.nextLine();
            System.out.println("");
            System.out.print("Digite a Qntd: ");
            qntd = teclado.nextFloat();
            System.out.println("");
            System.out.print("Digite o preço: ");
            preco = teclado.nextFloat();
            pp = new ProdutoPeso(nome,preco,isbn,qntd);
            addproduto(pp);
        }else if((isbn / 100) < 5){
            ProdutoUnidade pu;
            System.out.print("Digite o nome: ");
            nome = tecladonome.nextLine();
            System.out.println("");
            System.out.print("Digite a Qntd: ");
            qntd = teclado.nextInt();
            System.out.println("");
            System.out.print("Digite o preço: ");
            preco = teclado.nextFloat();
            pu = new ProdutoUnidade(nome,preco,isbn, (int) qntd);
            addproduto(pu);
        } 
        
        
        }
    public Produto temestoque(int isbn){
        int aux;
        for(Produto p : l_produto){
            aux = p.getisbn();
            if(aux == isbn){
                return p;
            }
        }
        return null;
    }
    
    public void getEstoque(){
        for(Produto p: l_produto){
             if(p instanceof ProdutoUnidade){
                 ProdutoUnidade pu = (ProdutoUnidade) p;
                 System.out.println("Produto: " + pu.getnome());
                 System.out.println("ISBN: "+ pu.getisbn());
                 System.out.println("Preço: "+ pu.getpreco());
                 System.out.println("Quantidade: " + pu.getQntd());
                 System.out.println("--------------------");
                 
             }else {
                 ProdutoPeso pp = (ProdutoPeso)p;
                 System.out.println("Produto: "+ pp.getnome());
                 System.out.println("ISBN: "+ pp.getisbn());
                 System.out.println("Preço: "+ pp.getpreco());
                 System.out.println("Quantidade: "+ pp.getQntd());
                 System.out.println("--------------------");
             }
        }
    }
    
    public ArrayList<Produto> getLProdutos(){
        return this.l_produto;
    }
    
    public void decrementaEstoque(Produto produto,float peso){
        int index = l_produto.indexOf(produto);
        if (index >= 0){
            ProdutoPeso pp = (ProdutoPeso) produto;
            pp.setQntd(-peso);
            l_produto.remove(index);
            l_produto.add(index, pp);
        }
        /*for(Produto p : l_produto){
            if(p.equals(produto)){
                ProdutoPeso pp = (ProdutoPeso) p;
                pp.setQntd(-peso);
                p = pp;
                break;
            }
        }*/
    }
    
    public void decrementaEstoque(Produto produto){
        int index = l_produto.indexOf(produto);
        if (index >= 0){
            ProdutoUnidade pu =  (ProdutoUnidade) l_produto.get(index);
            pu.setQntd(-1);
            l_produto.remove(index);
            l_produto.add(index, pu);
        }
        /*for(Produto p : l_produto){
            if(p.equals(produto)){
                ProdutoUnidade pu = (ProdutoUnidade) p;
                pu.setQntd(-1);
                break;
            }
        }*/
    }

}
