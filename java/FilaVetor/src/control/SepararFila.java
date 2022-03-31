package control;

import model.FilaInterface;
import model.SepararFilaInterface;

public class SepararFila implements SepararFilaInterface {
	
	private FilaInterface fila1;
	private FilaInterface fila2;
	private FilaInterface fila3;
	
	public SepararFila(FilaInterface fila1, FilaInterface fila2, FilaInterface fila3) {
		this.fila1 = fila1;
		this.fila2 = fila2;
		this.fila3 = fila3;
	}
	
	public void separar() {
		
		while(!this.fila1.estaVazia()) {
			System.out.println("-----");
			this.fila1.setNome("Fila original");
			int numero = fila1.desenfirelar();
			this.fila1.setNome("Fila Impar");
			if((numero % 2) == 0) {
				this.fila2.enfirelar(numero);
			}else {
				this.fila3.enfirelar(numero);
			}

		}
		
		this.fila1.resetarFila();
		
		while(!this.fila3.estaVazia()) {
			int numero = this.fila3.desenfirelar();
			this.fila1.enfirelar(numero);
		}
		System.out.println("-----");
		
		this.fila3.resetarFila();
	}

	public FilaInterface filaImpar() {
		return this.fila1;
	}
	
	public FilaInterface filaPar() {
		return this.fila2;
	}
	
	public FilaInterface filaVazia() {
		return this.fila3;
	}
}
