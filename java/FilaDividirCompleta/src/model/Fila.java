package model;

public class Fila {
	
	private Integer[] fila;
	private int numeroElementos;
	private int maxSize;
	private int inicio;
	private String nome;
	private int topo;
	
	public Fila(String nome) {
		this.nome = nome;
		this.maxSize = 10;
		this.inicio = 0;
		this.topo = 0;
		this.fila = new Integer[maxSize];
		this.resetarFila();
	}

	public void Enfirelar(int valor){
		if(numeroElementos < maxSize){
			System.out.println(valor + " --> " + this.nome + " | Posição: " + (this.inicio + this.numeroElementos) % this.maxSize);
			this.fila[(this.inicio + this.numeroElementos) % this.maxSize] = valor;
			this.numeroElementos++;
			this.topo++;
		}else{
			System.out.println("A FILA ESTÁ CHEIA!!");
		}
	}
	
	public Integer Desenfilerar(){
		int value = this.fila[inicio];
		if(numeroElementos > 0){
			this.inicio = (this.inicio + 1) % this.maxSize;
			this.numeroElementos--;
			System.out.println(value + " <-- " + this.nome);
		}else{
			System.out.println("NÃO HÁ MAIS NENHUM DADO PARA DESENFIRELAR!!");
		}
		
		return value;
	}
	
	public Integer numeroElementos(){
		return this.numeroElementos;
	}
	
	public Integer topo() {
		return this.topo;
	}
	
	public Integer inicio(){
		return this.inicio;
	}
	
	public Integer valorPilha(int v){
		return this.fila[v];
	}
	
	public Integer tamanhoMaximo(){
		return this.maxSize;
	}
	
	public boolean pilhaVazia(){
		if(this.numeroElementos == 0) return true;
		else return false;
	}
	
	public void resetarFila(){
		for(int i=0; i<this.maxSize; i++){
			this.fila[i] = 0;
		}
	}
}
