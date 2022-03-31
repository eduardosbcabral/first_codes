package model;

import java.util.ArrayList;

public class Lista {
	
	private int id_lista;
	private String descricao;
	
	public Lista (int id_lista, String descricao){
		this.id_lista = id_lista;
		this.descricao = descricao;
	}

	public int getId_lista() {
		return id_lista;
	}

	public void setId_lista(int id_lista) {
		this.id_lista = id_lista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
