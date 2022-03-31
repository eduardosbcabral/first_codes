package control;

import model.Telefone;

public class ListaEncadeada {

	private No primeiro;
	private int nroNos;
	
	public ListaEncadeada(){
		this.primeiro = null;
		this.nroNos = 0;
	}
	
	public boolean isVazia(){
		return (primeiro==null);
	}
	
	public void criarNo(Telefone telefone){
		nroNos++;
		No novoNo = new No(telefone);
		
		if(!this.isVazia()) novoNo.prox = primeiro;
		
		this.primeiro = novoNo;
	}
	
	public Telefone removerNo(No no) {
		Telefone tel = null;
		if(no != null) {
			tel = this.primeiro.telefone;
			this.primeiro = this.primeiro.prox;
			this.nroNos--;
		}else {
			System.out.println("UnderFlow");
		}
		
		return tel;
	}
	
	public void esvaziarTodaLista() {
		this.esvaziar(this.primeiro);
	}
	
	private void esvaziar(No no) {
		if(no != null) {
			removerNo(no);
			esvaziar(no.prox);
		}
	}
	
	public void listar(){
		if(this.nroNos==0) {
			System.out.println("[]");
		}else {
			String lista = "[";
			No atual = this.primeiro;
			for(int i=0; i<this.nroNos-1; i++) {
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
