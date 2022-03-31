package model;

public class Carro {
	//Atributos
	private int idCarro;
	private String modelo;
	private String anoFab;
	private String marca;
	
	public Carro(int idCarro, String modelo, String anoFab, String marca){
		this.idCarro = idCarro;
		this.modelo = modelo;
		this.anoFab = anoFab;
		this.marca = marca;
	}
	
	//Metodos
	public int getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnoFab() {
		return anoFab;
	}
	public void setAnoFab(String anoFab) {
		this.anoFab = anoFab;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
