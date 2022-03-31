package control;

public class Pilha {
	
	private int maxSize;
	
	private int topo;
	
	private Integer[] pilha;
	
	public Pilha(){
		this.maxSize = 0;
		this.topo = 0;
		this.pilha = new Integer[maxSize];
	}
	
	public void empilha(int i){
		try {
			this.pilha[topo] = i;
			this.topo++;
		} catch (ArrayIndexOutOfBoundsException e) {		
			juntarPilhas(aumentarPilha(i));
		}
	}
	
	public Integer desempilha(){
		this.topo--;
		return this.pilha[topo];
	}

	private Integer[] aumentarPilha(int num){
		maxSize++;
		
		Integer[] novaPilha = new Integer[maxSize];
		
		for (int i = 0; i < maxSize - 1; i++)
		{
			novaPilha[i] = this.pilha[i];
		}
		
		topo++;
		novaPilha[maxSize-1] = num;
		
		return novaPilha;
	}
	
	private void juntarPilhas(Integer[] novaPilha){
		
		this.pilha = new Integer[maxSize];
		
		for(int i = 0; i < maxSize; i++)
		{
			this.pilha[i] = novaPilha[i];
		}
	}
	
	public boolean vazia(){
		if(this.topo == 0)
			return true;
		else
			return false;
	}
	
	public int vTopo(int v){
		return this.pilha[v];
	}
	
	public int numTopo(){
		return this.topo;
	}
	
	public Integer[] pilhaE(){
		return this.pilha;
	}
}
