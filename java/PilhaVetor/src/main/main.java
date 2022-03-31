package main;

import control.Pilha;
import control.SepararPilha;
import model.PilhaInterface;

public class main {

	public static void main (String[] args) {
		PilhaInterface p1 = new Pilha("Pilha Original");
		PilhaInterface p2 = new Pilha("Pilha Par");
		PilhaInterface p3 = new Pilha("Pilha Auxiliar");
		
		p1.empilhar(1);
		p1.empilhar(2);
		p1.empilhar(3);
		p1.empilhar(4);
		p1.empilhar(5);
		p1.listar();
		
		SepararPilha spi = new SepararPilha(p1, p2, p3);
		
		spi.separar();
		
		p1 = spi.pilhaImpar();
		p2 = spi.pilhaPar();
		p3 = spi.pilhaVazia();
		
		p3.setNome("Pilha vazia");
		
		p1.listar();
		p2.listar();
		p3.listar();
		
		
	}
	
}
