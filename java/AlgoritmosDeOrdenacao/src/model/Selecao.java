package model;

import java.util.ArrayList;

public class Selecao {

	private ArrayList<Integer> array;
	
	public Selecao() {
		this.array = new ArrayList<Integer>();
		this.array.add(3);
		this.array.add(7);
		this.array.add(1);
		this.array.add(6);
		this.ordenar();
	}
	
	public void ordenar() {
		for(int i=0; i<=this.array.size()-2; i++) {
			System.out.println("i = " + i);
			System.out.println("  c = " + i);
			int c = i;
			System.out.println("  t = " + "A["+i+"]("+this.array.get(i)+")");
			int t = this.array.get(i);
			for(int j=i+1; j <=this.array.size()-1; j++) {
				System.out.println("    j = " + j);
				System.out.println("      se(A["+j+"]("+this.array.get(j)+ ") < t("+t+"))");
				if(this.array.get(j) < t) {
					System.out.println("        c = j("+j+")");
					c = j;
					System.out.println("        t = A["+j+"]("+this.array.get(j)+")");
					t = this.array.get(j);
					
				}else {
					System.out.println("      False");
				}
			}
			System.out.println("  A["+c+"] = A["+i+"]("+this.array.get(i)+")");
			this.array.set(c, this.array.get(i));
			System.out.println("  A["+i+"] = t("+t+")");
			this.array.set(i, t);
			System.out.println("                            " + this.listar());
			System.out.println("---------------------------");
		}
		System.out.println("----------ORDENOU---------");
	}
	
	public String listar() {
		String lista = "A = [";
		for(int i=0; i<this.array.size(); i++) {
			if(i==0) lista += this.array.get(i);
			else lista += "," + this.array.get(i);
		}
		lista += "]";
		
		return lista;
	}
	
}
