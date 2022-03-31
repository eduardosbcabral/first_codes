package main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int quantidadeCaracteres = 0;
		int quantidadeEspacos = 0;
		
		System.out.println("Digite uma frase: ");
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		String fraseSemEspaco = "";
		
		for(int i=0; i<frase.length(); i++) {
			if(frase.charAt(i) == ' ') {
				quantidadeEspacos++;
			}else{
				quantidadeCaracteres++;
				fraseSemEspaco += frase.charAt(i);
			}
		}
		
		System.out.println("Voce escreveu " + quantidadeCaracteres + " caracteres e " + quantidadeEspacos + " espacos em branco");
		System.out.println("Total de " + (quantidadeCaracteres + quantidadeEspacos) + " caracteres.");
		System.out.println("Frase sem espaco: " + fraseSemEspaco);
	}
	
}
