package control;

import model.ListaTelefonesInterface;
import model.Telefone;

public class ListaTelefones implements ListaTelefonesInterface {
	
	private int maximoTelefones;
	
	private Telefone[] vetorTelefone;
	
	private int quantidadeTelefones;

	public void criarNova() {
		this.maximoTelefones = 10;
		this.vetorTelefone = new Telefone[maximoTelefones];
		this.quantidadeTelefones = 0;
	}
	
	public void inserir(Telefone telefone) {
		if(quantidadeTelefones < maximoTelefones) {
			vetorTelefone[quantidadeTelefones++] = telefone;
		} else {
			System.err.println("Overflow");
		}
	}
	
	public boolean remover(Telefone telefone) {
		int indice = buscar(telefone);
		
		if(indice==-1) return false;
		else {
			vetorTelefone[indice] = vetorTelefone[--quantidadeTelefones];
			return true;
		}
	}
	
	public int buscar(Telefone telefone) {
		int indice = -1;
		
		for(int i=0; i<this.quantidadeTelefones; i++) {
			if(vetorTelefone[i].getNumero() == telefone.getNumero()) {
				indice = i;
				System.out.println("Telefone encontrado!");
			}
		}
		if(indice == -1) System.out.println("Telefone não encontrado");
		
		return indice;
	}
	
	public void listar() {
		System.out.println("-----");
		for(int i=0; i<quantidadeTelefones; i++) {
			System.out.println("Telefone " + i + ": " + vetorTelefone[i].getNumero());
		}
		System.out.println("-----");
	}
	
}
