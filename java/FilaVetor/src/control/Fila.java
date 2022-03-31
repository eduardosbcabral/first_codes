package control;

import model.FilaInterface;

public class Fila implements FilaInterface {
	
	private int tamanhoMaximo;
	
	private int inicio;
	
	private int topo;
	
	private int numeroElementos;
	
	private int[] fila;
	
	private String nome;
	
	public Fila(String nome) {
		this.nome = nome;
		this.tamanhoMaximo = 10;
		this.inicio = 0;
		this.topo = 0;
		this.numeroElementos = 0;
		this.fila = new int[tamanhoMaximo];
		this.resetarFila();
	}
	
	public void enfirelar(int numero) {
		if(numeroElementos < tamanhoMaximo) {
			System.out.println("Enfilerado: " + numero + " (" + this.nome + ")" + " | Posição: " + (this.inicio + this.numeroElementos) % this.tamanhoMaximo);
			this.fila[(this.inicio + this.numeroElementos) % this.tamanhoMaximo] = numero; //Retorna um valor e se resultar num valor igual ao tamanho máximo ele vira 0
			this.numeroElementos++;
			this.topo++;
		}else System.out.println("Overflow");
	}
	
	public int desenfirelar() {
		int numero = this.fila[inicio];
		if(numeroElementos > 0) {
			System.out.println("Desenfirelado: " + numero + " (" + this.nome + ")" + " | Posição: " + this.inicio);
			this.inicio = (this.inicio + 1) % this.tamanhoMaximo; //Retorna o valor do início+1 e se resultar num valor igual ao tamanho máximo ele vira 0
			this.numeroElementos--;
		}else System.out.println("Underflow");
		
		return numero;
	}
	
	public void listar() {
		System.out.println("--" + this.nome + "--");
		for(int i=0; i<this.tamanhoMaximo; i++) {
			String zero = "";
			if(this.fila[i] == 0)
				zero = " (Espaço Vazio)";
			System.out.println("Posição " + i + ": " + this.fila[i] + zero);
		}
		System.out.println("-----");
	}

	public boolean estaVazia() {
		if(this.numeroElementos == 0) return true;
		else return false;
	}
	
	public String nomePilha() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void resetarFila(){
		for(int i=0; i<this.tamanhoMaximo; i++){
			this.fila[i] = 0;
		}
	}
}
