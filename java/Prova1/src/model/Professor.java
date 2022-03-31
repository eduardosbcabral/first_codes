package model;

import java.sql.Date;

public class Professor {
	
	private int id_professor;
	private String nome;
	private String data_nasc;
	private String nome_mae;
	private int intitulacao;
	
	public Professor (int id_professor, String nome, String data_nasc, String nome_mae, int intitulacao){
		this.id_professor = id_professor;
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.nome_mae = nome_mae;
		this.intitulacao = intitulacao;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public int getIntitulacao() {
		return intitulacao;
	}

	public void setIntitulacao(int intitulacao) {
		this.intitulacao = intitulacao;
	}
	
	
	
	

}
