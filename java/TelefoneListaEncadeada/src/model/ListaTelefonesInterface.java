package model;

public interface ListaTelefonesInterface {
	
	public void criarNova();
	
	public int buscar(Telefone telefone);
	
	public boolean remover(Telefone telefone);
	
	public void inserir(Telefone telefone);
	
	public void listar();

}
