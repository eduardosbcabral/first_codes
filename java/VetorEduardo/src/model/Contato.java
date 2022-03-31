package model;

public class Contato {
	
	private String nome;
	private String numero;
	
	public Contato (String nome, String numero)
	{
		this.setNome(nome);
		this.setNumero(numero);
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome()
	{
		return this.nome;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public String getNumero(String numero)
	{
		return this.numero;
	}

}
