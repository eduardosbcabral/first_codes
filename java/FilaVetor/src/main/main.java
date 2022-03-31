package main;

import control.Fila;
import control.SepararFila;
import model.FilaInterface;
import model.SepararFilaInterface;

public class main {
	
	public static void main(String[] args) {
		FilaInterface f1 = new Fila("Fila Original");
		FilaInterface f2 = new Fila("Fila Par");
		FilaInterface f3 = new Fila("Fila Auxiliar");
		
		for(int i=1; i<8; i++) f1.enfirelar(i);
		
		f1.desenfirelar();
		f1.enfirelar(50);
		f1.listar();
		
		SepararFilaInterface spi = new SepararFila(f1, f2, f3);
		
		spi.separar();
		
		f1 = spi.filaImpar();
		f2 = spi.filaPar();
		f3 = spi.filaVazia();
		
		f1.listar();
		f2.listar();
		f3.listar();
	}

}
