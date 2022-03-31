package model;

public class Pessoa {
	
	private int id_pessoa;
	private String nome;
	private String senha;
	private String endereco_pessoa;
	private String uf_pessoa;
	
	public Pessoa (int id_pessoa, String nome, String endereco_pessoa, String uf_pessoa){
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.endereco_pessoa = endereco_pessoa;
		this.uf_pessoa = uf_pessoa;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco_pessoa() {
		return endereco_pessoa;
	}

	public void setEndereco_pessoa(String endereco_pessoa) {
		this.endereco_pessoa = endereco_pessoa;
	}

	public String getUf_pessoa() {
		return uf_pessoa;
	}

	public void setUf_pessoa(String uf_pessoa) {
		this.uf_pessoa = uf_pessoa;
	}
	
	

}
