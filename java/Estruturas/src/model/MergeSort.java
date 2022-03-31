package model;

public class MergeSort {

	private int[] vetor;
	private int numeroElementos;
	private int tamMax;
	
	public MergeSort(){
		this.numeroElementos = 0;
		this.tamMax = 4;
		this.vetor = new int[tamMax];
		this.adicionar(7);
		this.adicionar(1);
		this.adicionar(4);
		this.adicionar(2);
		this.ordenar(this.vetor, 0, this.numeroElementos);
		this.listar();
	}
	
	public void adicionar(int num){
		this.vetor[numeroElementos] = num;
		this.numeroElementos++;
	}
	
	public void ordenar(int[] a, int i, int n){
		if(n > 1){
			int m = n / 2;
			ordenar(a, i, m);
			ordenar(a, i+m, n-m);
			this.merge(a, i, i+m, n);
		}
	}
	
	public void merge(int[] a, int i1, int i2, int n){
		int[] b = new int[tamMax];
		int i = i1;
		int j = i2;
		int k = i1;
		while(i<i2 && j<i1 + n){
			if(a[i] <= a[j]){
				b[k] = a[i];
				i++;
			}else{
				b[k] = a[j];
				j++;
			}
			k++;
		}
		while(i<i2){
			b[k] = a[i];
			i++;
			k++;
		}
		
		for(i=i1; i<=j-1; i++){
			a[i] = b[i];
		}
	}
	
	public void listar(){
		for(int i=0; i<this.numeroElementos; i++){
			System.out.println(","+this.vetor[i]+",");
		}
	}
}