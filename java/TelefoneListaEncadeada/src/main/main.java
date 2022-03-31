package main;

import control.Fila;
import control.ListaEncadeada;
import control.Pilha;
import model.Telefone;

public class main {

	public static void main (String[] args) {
		/*ListaTelefonesInterface listaTelefones = new ListaTelefones();
		listaTelefones.criarNova();
		listaTelefones.inserir(new Telefone("1111-1111"));
		listaTelefones.inserir(new Telefone("2222-2222"));
		listaTelefones.inserir(new Telefone("3333-3333"));
		listaTelefones.inserir(new Telefone("4444-4444"));
		listaTelefones.listar();
		listaTelefones.inserir(new Telefone("5555-5555"));
		listaTelefones.inserir(new Telefone("6666-6666"));
		listaTelefones.remover(new Telefone("3333-3333"));
		listaTelefones.listar();*/
		
		/*ListaEncadeada le = new ListaEncadeada();		
		le.criarNo(new Telefone("1111-1111"));
		le.criarNo(new Telefone("2222-2222"));
		le.listar();
		le.esvaziarTodaLista();
		le.listar();*/
		
		/*Pilha p = new Pilha();
		p.empilhar(new Telefone("1111-1111"));
		p.empilhar(new Telefone("2222-2222"));
		p.listar();
		System.out.println("Desempilhado: " + p.desempilhar().getNumero());
		p.listar();*/
		
		Fila f = new Fila();
		f.enfirelar(new Telefone("1111-1111"));
		f.enfirelar(new Telefone("2222-2222"));
		f.enfirelar(new Telefone("3333-3333"));
		f.listar();
		f.desenfilerar();
		f.listar();
		f.enfirelar(new Telefone("4444-4444"));
		f.desenfilerar();
		f.listar();
	}
	
}
