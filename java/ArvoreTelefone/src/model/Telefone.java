package model;

import java.util.Random;

public class Telefone {
	
	public int indice;
	
	public String numero;
	
	public Telefone(String numero){
		this.numero = numero;
		
		Random r = new Random();
		this.indice = r.nextInt(100);
	}

}
