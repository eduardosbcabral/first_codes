package model;

public class Fila {
	
	private Integer[] fila;
	private int numElem;
	private int inicio;
	private int maxSize;
	
	public Fila() {
		this.maxSize = 10;
		this.inicio = 0;
		this.fila = new Integer[maxSize];
	}

	public void Enfirelar(int valor){
		try{
			this.fila[(this.inicio + this.numElem) % this.maxSize] = valor;
			this.numElem++;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("A fila está cheia!");
		}
	}
	
	public Integer Desenfilerar(){
		try{
			this.inicio = (this.inicio + 1) % this.maxSize;
			this.numElem--;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("A fila está vazia!");
		}
		
		return this.fila[this.inicio];
	}
	
	public Integer elem(){
		return this.numElem;
	}
	
	public Integer numElem(int v){
		return this.fila[v];
	}
}
