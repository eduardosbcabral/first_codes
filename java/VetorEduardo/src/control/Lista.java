package control;

import model.Contato;

public class Lista {

	private int maxSize;

	private Contato[] lista;
	
	public Lista()
	{
		this.maxSize = 0;
		this.lista = new Contato[maxSize];
	}
	
	public void addContato(Contato c) {
		try {
			this.lista[maxSize] = c;
		} catch (ArrayIndexOutOfBoundsException e) {		
			juntarListas(aumentarLista(c));
		}

	}

	public Contato[] aumentarLista(Contato c) {
		maxSize++;
		Contato[] novaLista = new Contato[maxSize];
		
		for (int i = 0; i < maxSize - 1; i++)
		{
			novaLista[i] = lista[i];
		}
		
		novaLista[maxSize-1] = c;
		
		return novaLista;
	}

	public void juntarListas(Contato[] novaLista) {

		this.lista = new Contato[maxSize];
		
		for(int i = 0; i < maxSize; i++)
		{
			this.lista[i] = novaLista[i];
		}
		
	}
	
	public Contato[] getLista()
	{
		return this.lista;
	}
	
	public int getMaxSize()
	{
		return this.maxSize;
	}

}
