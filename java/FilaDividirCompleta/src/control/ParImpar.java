package control;

import model.Fila;

public class ParImpar {
	
	private Fila fila1;
	private Fila fila2;
	private Fila fila3;
	
	public ParImpar(Fila fila1, Fila fila2, Fila fila3){
		this.fila1 = fila1;
		this.fila2 = fila2;
		this.fila3 = fila3;
	}
	
	public void Separar(){
		
		System.out.println("----------------Empilhando Nº PAR na Pilha 2----------------");
		while(!this.fila1.pilhaVazia()){
			int valor = this.fila1.Desenfilerar();
			
			if((valor % 2) == 0) this.fila2.Enfirelar(valor);
			else this.fila3.Enfirelar(valor);
		}
		
		this.fila1.resetarFila();
		
		System.out.println("----------------Empilhando Nº IMPAR na Pilha 1----------------");
		while(!this.fila3.pilhaVazia()){
			int valor = fila3.Desenfilerar();
			this.fila1.Enfirelar(valor);
		}
		
		this.fila3.resetarFila();
	}	

	
	public Fila filaImpar(){
		return this.fila1;
	}
	
	public Fila filaPar(){
		return this.fila2;
	}
	
	public Fila filaVazia(){
		return this.fila3;
	}

}
