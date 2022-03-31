package control;

import model.PilhaInterface;

public class SepararPilha {
	
	private PilhaInterface pilha1;
	private PilhaInterface pilha2;
	private PilhaInterface pilha3;

	public SepararPilha(PilhaInterface p1, PilhaInterface p2, PilhaInterface p3) {
		this.pilha1 = p1;
		this.pilha2 = p2;
		this.pilha3 = p3;
	}

	public void separar() {
		System.out.println("-----");
		while(!this.pilha1.estaVazia()) {
			this.pilha1.setNome("Pilha original");
			int numero = this.pilha1.desempilhar();
			this.pilha1.setNome("Pilha Impar");
			if((numero % 2) == 0) {
				this.pilha2.empilhar(numero);
			}
			else {
				this.pilha3.empilhar(numero);
			}
		}
		
		while(!this.pilha3.estaVazia()) {
			int numero = this.pilha3.desempilhar();
			this.pilha1.empilhar(numero);
		}
		System.out.println("-----");
	}
	
	public PilhaInterface pilhaImpar() {
		return this.pilha1;
	}
	
	public PilhaInterface pilhaPar() {
		return this.pilha2;
	}
	
	public PilhaInterface pilhaVazia() {
		return this.pilha3;
	}
}
