package control;

import model.Telefone;

public class Pilha {

	private int tamanho;
	private No topo;
	
	public Pilha() {
		tamanho = 0;
		topo = null;
	}
	
	public void empilhar(Telefone tel) {
		No aux = new No(tel);
		if(this.tamanho != 0) {
			aux.prox = topo;
		}
		topo = aux;
		tamanho++;
	}
	
	public Telefone desempilhar() {
		No aux = topo;
		if(this.topo != null) {
			this.topo = aux.prox;
			tamanho--;
		}
		return aux.telefone;
	}
	
	public void listar(){
		if(this.tamanho==0) {
			System.out.println("[]");
		}else {
			String lista = "[";
			No atual = this.topo;
			for(int i=0; i<this.tamanho-1; i++) {
				lista += atual.telefone.getNumero();
				lista += ", ";
				atual = atual.prox;
			}
			lista += atual.telefone.getNumero();
			lista += ("]");
			System.out.println("Lista: " + lista);
		}

	}
}
