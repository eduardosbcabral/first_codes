package model;

public interface PilhaInterface {
	
	void empilhar(int numero);
	
	int desempilhar();
	
	void listar();
	
	boolean estaVazia();

	String nomePilha();
	
	void setNome(String nome);
}
