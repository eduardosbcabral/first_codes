package main;

import model.Arvore;

public class Main {
	
	public static void main(String[] args) {
		Arvore a = new Arvore();

        a.adicionarNo(13);
        a.adicionarNo(5);
        a.adicionarNo(7);
        a.adicionarNo(10);
        a.adicionarNo(8);
        a.adicionarNo(1);
        a.adicionarNo(20);
        a.adicionarNo(22);
        a.adicionarNo(18);
        a.removerNo(5);
        
        a.buscarNo(5);
	}

}
