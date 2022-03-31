package main;

import control.ListaTelefones;
import model.ListaTelefonesInterface;
import model.Telefone;

public class main {

	public static void main (String[] args) {
		ListaTelefonesInterface listaTelefones = new ListaTelefones();
		listaTelefones.criarNova();
		listaTelefones.inserir(new Telefone("1111-1111"));
		listaTelefones.inserir(new Telefone("2222-2222"));
		listaTelefones.inserir(new Telefone("3333-3333"));
		listaTelefones.inserir(new Telefone("4444-4444"));
		listaTelefones.listar();
		listaTelefones.inserir(new Telefone("5555-5555"));
		listaTelefones.inserir(new Telefone("6666-6666"));
		listaTelefones.remover(new Telefone("3333-3333"));
		listaTelefones.listar();
	}
	
}
