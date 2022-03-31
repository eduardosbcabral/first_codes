package main;

import javax.swing.JOptionPane;

import control.ParImpar;
import model.Fila;

public class Main {
	
	public static void main(String[] args){
		Fila fila1 = new Fila("Fila 1");
		Fila fila2 = new Fila("Fila 2");
		Fila fila3 = new Fila("Fila 3");

		String filaOriginal = "";		
		String valoresP1 = "";
		String valoresP2 = "";
		String valoresP3 = "";
		
		for(int i=1; i<9; i++) {
			fila1.Enfirelar(i);
			filaOriginal +=  i + " | ";
		}

		ParImpar pi = new ParImpar(fila1, fila2, fila3);

		pi.Separar();
		
		fila1 = pi.filaImpar();
		fila2 = pi.filaPar();
		fila3 = pi.filaVazia();
		
		System.out.println("------------------------");

		
		for(int i=0; i<fila1.tamanhoMaximo();i++) valoresP1 +=  fila1.valorPilha(i) + " | ";

		for(int i=fila2.inicio(); i<fila2.tamanhoMaximo(); i++) valoresP2 += fila2.valorPilha(i) + " | ";

		for(int i=0; i<fila3.tamanhoMaximo(); i++) valoresP3 += fila3.valorPilha(i) + " | ";
		
		JOptionPane.showMessageDialog(null, "Fila original: " + filaOriginal + "\n" + "Fila impar: " + valoresP1 + "\n" + "Fila par: " + valoresP2 + "\n" + "Fila 3: " + valoresP3);
	
	}

}
