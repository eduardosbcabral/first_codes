package model;

public class Contato {
	
	private int id_contato;
	private int id_pessoa;
	private String tipo_contato;
	private String contato;
	
	public Contato (int id_contato, int id_pessoa, String tipo_contato, String contato){
		this.id_contato = id_contato;
		this.id_pessoa = id_pessoa;
		this.tipo_contato = tipo_contato;
		this.contato = contato;
	}

	public int getId_contato() {
		return id_contato;
	}

	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getTipo_contato() {
		return tipo_contato;
	}

	public void setTipo_contato(String tipo_contato) {
		this.tipo_contato = tipo_contato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
}
