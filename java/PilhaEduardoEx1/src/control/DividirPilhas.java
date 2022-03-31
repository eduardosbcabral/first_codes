package control;

public class DividirPilhas {
	
	private Pilha p1;
	private Pilha p2;
	private Pilha p3;
	
	public DividirPilhas(Pilha p1, Pilha p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.dividirImparPar();
	}
	
	private void dividirImparPar()
	{
		
		this.p3 = new Pilha();
		
		while(!p1.vazia())
		{
			int value = p1.desempilha();
			
			if((value % 2) == 0){
				p2.empilha(value);
			}else{
				p3.empilha(value);
			}
		}

	}
	
	public Pilha pilhaImpar()
	{
		return this.p3;
	}
	
	public Pilha pilhaPar()
	{
		return this.p2;
	}
	
}
