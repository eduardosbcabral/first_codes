package model;

import java.util.ArrayList;

public class Insercao {

private ArrayList<Integer> array;
	
	public Insercao() {
		this.array = new ArrayList<Integer>();
		this.array.add(3);
		this.array.add(7);
		this.array.add(1);
		this.array.add(6);
		this.ordenar();
	}
	
	public void ordenar() {
		for(int i=1; i<=this.array.size()-1; i++) {
			System.out.println("i = " + i);
			System.out.println("  t = A["+i+"]("+this.array.get(i)+")");
			int t = this.array.get(i);
			System.out.println("  j = "+i+"-1");
			int j = i-1;
			System.out.println("    enquanto(j("+j+")>= 0 && t("+t+") < A["+j+"]("+this.array.get(j)+")) {");
			while(j>=0&&t<this.array.get(j)) {
				System.out.println("      A["+(j+1)+"] = A["+j+"]("+this.array.get(j)+")");
				this.array.set(j+1, this.array.get(j));
				System.out.println("      j = "+j+"-1");
				j--;
				System.out.println("     -----------");
			}
			System.out.println("    }");
			System.out.println("  A["+(j+1)+"] = t("+t+")");
			this.array.set(j+1, t);
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
