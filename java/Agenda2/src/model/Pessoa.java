package model;

public class Pessoa {
	
	private int id_pessoa;
	private String nome;
	private String endereco;
	private String UF;
	
	public Pessoa(int id_pessoa, String nome, String endereco, String uf) {
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.endereco = endereco;
		this.UF = uf;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}
	
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getUf() {
		return UF;
	}
	
	public void setUf(String uf) {
		this.UF = uf;
	}
	
	

}
