package model;

import java.util.ArrayList;

public class Arvore {
	
	private No raiz;
	private ArrayList<Integer> indices = new ArrayList<Integer>();
	
	public boolean adicionarNo(Telefone tel) {
		if (this.raiz == null)
        {
            System.out.println("(" + tel.numero + ") foi adicionado como nó raiz da árvore");
            this.raiz = new No(tel);
            return true;
        }
        else
        {
            return adicionarNo(this.raiz, tel);
        }
	}
	
	public boolean adicionarNo(No aux, Telefone tel)
    {
        if(tel.indice < aux.tel.indice)
        {
            if (aux.filhoEsquerdo != null) return adicionarNo(aux.filhoEsquerdo, tel);
            else
            {
            	System.out.println("(" + tel.numero + ") foi adicionado no filho esquerdo do nó (" + aux.tel.indice + ")");
            	aux.filhoEsquerdo = new No(tel);
            	int indiceAtual = aux.filhoEsquerdo.tel.indice;
            	this.indices.add(indiceAtual);
            	return true;
            }
        }
        else if (tel.indice > aux.tel.indice)
        {
            if (aux.filhoDireito != null) return adicionarNo(aux.filhoDireito, tel);
            else
            {
            	System.out.println("(" + tel.numero + ") foi adicionado no filho direito do nó (" + aux.tel.indice + ")");
            	aux.filhoDireito = new No(tel);
            	int indiceAtual = aux.filhoDireito.tel.indice;
            	this.indices.add(indiceAtual);
            	return true;
            }

        }else if (tel.indice == aux.tel.indice){
        	System.out.println("Indices iguais");
    		return false;
        }
        else
        {
            return false;
        }
    }
	
    
    public boolean buscarNo(Telefone tel) {
    	boolean result = buscarNo(tel, this.raiz);
    	if(!result) System.out.println("Nó (" + tel.numero + ") não encontrado!");
    	else System.out.println("Nó (" + tel.numero + ") encontrado!");
    	return result;
    }

    public boolean buscarNo(Telefone tel, No aux) {
    	if(aux != null) {
    		if(aux.tel.numero.equals(tel.numero)) return true;
    		else return buscarNo(tel, aux.filhoEsquerdo) || buscarNo(tel, aux.filhoDireito);
    	}
    	return false;
    }
    
    
    
    
    
    
    
    
	
	/*public void removerNo(int chave)
    {
        removerNo(this.raiz, chave, chave);
    }

    public No removerNo(No aux, int chave, int valor)
    {
        if (aux == null) return aux;

        if (chave < aux.chave) aux.filhoEsquerdo = removerNo(aux.filhoEsquerdo, chave, valor);
        else if (chave > aux.chave) aux.filhoDireito = removerNo(aux.filhoDireito, chave, valor);

        else
        {
            if (aux.filhoEsquerdo == null)
            {
            	System.out.println("(" + valor + ") retirado");
                return aux.filhoDireito;
            }
            else if (aux.filhoDireito == null)
            {
            	System.out.println("(" + valor + ") retirado");
                return aux.filhoEsquerdo ;
            }

            aux.chave = MenorValor(aux.filhoDireito);

            aux.filhoDireito = removerNo(aux.filhoDireito, aux.chave, valor);
        }
        return aux;
    }

    public int MenorValor(No aux)
    {
        int menor = aux.chave;

        while(aux.filhoEsquerdo != null)
        {
            menor = aux.filhoEsquerdo.chave;
            aux = aux.filhoEsquerdo;
        }

        return menor;
    }*/

}
