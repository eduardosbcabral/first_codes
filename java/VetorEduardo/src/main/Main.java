package main;

import control.Lista;
import model.Contato;

public class Main {

	public static void main(String[] args){
		
		Lista l = new Lista();
		
		Contato c1 = new Contato("Teste1", "111");
		Contato c2 = new Contato("Teste2", "222");
		Contato c3 = new Contato("Teste3", "333");
		Contato c4 = new Contato("Teste4", "444");
		Contato c5 = new Contato("Teste5", "555");
		Contato c6 = new Contato("Teste6", "666");
		Contato c7 = new Contato("Teste7", "777");
		Contato c8 = new Contato("Teste8", "888");
		Contato c9 = new Contato("Teste9", "999");
		Contato c10 = new Contato("Teste10", "1010");
		//Contato c11 = new Contato("Teste11", "1111"); //Teste
		//Contato c12 = new Contato("Teste12", "1212"); //Teste
		
		l.addContato(c1);
		l.addContato(c2);
		l.addContato(c3);
		l.addContato(c4);
		l.addContato(c5);
		l.addContato(c6);
		l.addContato(c7);
		l.addContato(c8);
		l.addContato(c9);
		l.addContato(c10);
		//l.addContato(c11); //Teste
		//l.addContato(c12); //Teste

		for(int i = 0; i < l.getMaxSize(); i++){
			System.out.println(l.getLista()[i].getNome());
		}
	}
	
}
