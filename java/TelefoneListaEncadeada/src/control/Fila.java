package control;

import model.Telefone;

public class Fila {
	
	private int tamanho;
	
	private No inicio;
	private No topo;
	
	public Fila() {
		tamanho = 0;
		this.inicio = null;
		this.topo = null;
	}

	public void enfirelar(Telefone telefone) {
		No aux = new No(telefone);
		if(this.tamanho==0) {
			this.inicio = aux;
			this.inicio.prox = aux;
			this.topo = aux;
			this.tamanho++;
		}else{
			aux.prox = this.topo;
			this.topo = aux;
			this.tamanho++;
		}

	}
	
	public Telefone desenfilerar() {
		No aux = this.inicio.prox;
		if(this.inicio==this.topo) {
			this.inicio = null;
			this.topo = null;
			this.tamanho--;
		}else {
			this.inicio = aux;
			this.tamanho--;
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
