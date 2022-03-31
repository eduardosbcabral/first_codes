package main;

import model.Fila;

public class Main {
	
	public static void main(String[] args){
		Fila fila = new Fila();
				
		fila.Enfirelar(1);
		fila.Enfirelar(2);
		fila.Enfirelar(3);
		fila.Enfirelar(4);
		fila.Enfirelar(5);
		fila.Enfirelar(6);
		fila.Enfirelar(7);
		fila.Enfirelar(8);
		fila.Enfirelar(9);
		fila.Enfirelar(10);
		fila.Enfirelar(11);
		fila.Desenfilerar();
		fila.Desenfilerar();
		
		for(int i=0; i<fila.elem(); i++){
			System.out.println(fila.numElem(i));
		}
	
	}

}
