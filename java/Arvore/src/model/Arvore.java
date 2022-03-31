package model;

public class Arvore {
	
	private No raiz;
	
	public boolean adicionarNo(int chave) {
		if (this.raiz == null)
        {
            System.out.println("(" + chave + ") foi adionado como nó raiz da árvore");
            this.raiz = new No(chave);
            return true;
        }
        else
        {
            return adicionarNo(this.raiz, chave);
        }
	}
	
	public boolean adicionarNo(No aux, int chave)
    {
        if(chave < aux.chave)
        {
            if (aux.filhoEsquerdo != null) return adicionarNo(aux.filhoEsquerdo, chave);
            else
            {
                System.out.println("(" + chave + ") foi adionado no filho esquerdo do nó (" + aux.chave + ")");
                aux.filhoEsquerdo = new No(chave);
                return true;
            }
        }
        else if (chave > aux.chave)
        {
            if (aux.filhoDireito != null) return adicionarNo(aux.filhoDireito, chave);
            else
            {
            	System.out.println("(" + chave + ") foi adionado no filho direito do nó (" + aux.chave + ")");
                aux.filhoDireito = new No(chave);
                return true;
            }

        }
        else
        {
            return false;
        }
    }
	
	public void removerNo(int chave)
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
    }
    
    public boolean buscarNo(int chave) {
    	boolean result = buscarNo(chave, this.raiz);
    	if(!result) System.out.println("Nó (" + chave + ") não encontrado!");
    	else System.out.println("Nó (" + chave + ") encontrado!");
    	return result;
    }

    public boolean buscarNo(int chave, No aux) {
    	if(aux != null) {
    		if(aux.chave == chave) return true;
    		else return buscarNo(chave, aux.filhoEsquerdo) || buscarNo(chave, aux.filhoDireito);
    	}
    	return false;
    }
}
