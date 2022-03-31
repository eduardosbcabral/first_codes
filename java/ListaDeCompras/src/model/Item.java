package model;

public class Item {
	
	private int id_item;
	private int id_lista;
	private String item;
	private double quantidade;
	
	public Item (int id_item, String item, double quantidade){
		this.id_item = id_item;
		this.item = item;
		this.quantidade = quantidade;
	}

	public int getId_item() {
		return id_item;
	}

	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public int getId_lista() {
		return id_lista;
	}

	public void setId_lista(int id_lista) {
		this.id_lista = id_lista;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
