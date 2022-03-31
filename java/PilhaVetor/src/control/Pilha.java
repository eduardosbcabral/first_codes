package control;

import model.PilhaInterface;

public class Pilha implements PilhaInterface{
	
	private int numeroElementos;
	
	private int[] pilha;
	
	private int topo;
	
	private int tamanhoMaximo;
	
	private String nome;
	
	public Pilha(String nome) {
		this.nome = nome;
		this.tamanhoMaximo = 10;
		this.numeroElementos = 0;
		this.pilha = new int[10];
		this.topo = 0;
	}

	public void empilhar (int numero) {
		if(numeroElementos < tamanhoMaximo) {
			pilha[numeroElementos++] = numero;
			System.out.println("Empilhado: " + numero + " (" + this.nome + ")");
		}else System.out.println("Overflow");
	}
	
	public int desempilhar() {
		Integer dado = pilha[numeroElementos];
		if(numeroElementos > 0) {
			dado = pilha[--numeroElementos];
			System.out.println("Desempilhado: " + dado + " (" + this.nome + ")");
		}else System.out.println("Underflow");
		
		return dado;
	}
	
	public void listar() {
		System.out.println("--" + this.nome + "--");
		for(int i=0; i<this.numeroElementos; i++) {
			System.out.println("Posição " + i + ": " + this.pilha[i]);
		}
		System.out.println("-----");
	}
	
	public boolean estaVazia() {
		if(this.numeroElementos == 0) return true;
		else return false;
	}

	public String nomePilha() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
