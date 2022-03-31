package main;

import control.DividirPilhas;
import control.Pilha;

public class Main {
	
	public static void main(String[] args){
		
		//EXERCÍCIO 1
		
		Pilha p1 = new Pilha();
		Pilha p2 = new Pilha();
		//Esta pilha é a pilha que deve estar vazia
		Pilha p3 = new Pilha();
		
		p1.empilha(1);
		p1.empilha(2);
		p1.empilha(3);
		p1.empilha(4);
		p1.empilha(5);
		p1.empilha(6);
		p1.empilha(7);
		p1.empilha(8);
		p1.empilha(9);

		System.out.println("---Empilhando---");
		for(int i=p1.numTopo()-1; i >= 0; i--){
			String topo = "";
			System.out.println("___");
			if(i==p1.numTopo()-1)
				topo = "(TOPO)";
			System.out.println("|" + p1.pilhaE()[i] + "|  Posição: " + i + "  " + topo);
		}
		System.out.println("\n");
		
		DividirPilhas dp = new DividirPilhas(p1, p2);
		
		p1 = dp.pilhaImpar();
		p2 = dp.pilhaPar();
		
		int topoP1 = p1.numTopo()-1;

		System.out.println("---Depois de desempilhar (PILHA IMPAR)---");
		for(int i=p1.numTopo()-1; i >= 0; i--){
			String t = "";
			System.out.println("___");
			if(i==p1.numTopo()-1)
				t = "(TOPO)";
			System.out.println("|" + p1.vTopo(topoP1) + "|  Posição: " + i + "  " + t);
			topoP1--;
		}
		
		System.out.println("\n");
		
		int topoP2 = p2.numTopo()-1;
		
		System.out.println("---Depois de desempilhar (PILHA PAR)---");
		for(int i=p2.numTopo()-1; i >= 0; i--){
			String t = "";
			System.out.println("___");
			if(i==p2.numTopo()-1)
				t = "(TOPO)";
			System.out.println("|" + p2.vTopo(topoP2) + "|  Posição: " + i + "  " + t);
			topoP2--;
		}
		
		/*System.out.println("\n");
		System.out.println("\n");
		
		System.out.println("---A pilha ímpar está vazia?---");
		System.out.println(p1.vazia());*/
	}

}
