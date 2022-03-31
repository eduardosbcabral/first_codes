package model;

import java.util.ArrayList;

public class Bolha {
	
	private ArrayList<Integer> array;
	
	public Bolha() {
		this.array = new ArrayList<Integer>();
		this.array.add(3);
		this.array.add(7);
		this.array.add(1);
		this.array.add(6);
		this.ordenar();
	}
	
	public void ordenar() {
		for(int i=0; i<=this.array.size()-2; i++) {
			for(int j=0; j<=(this.array.size()-i)-2; j++) {
				System.out.println("i = " + i);
				System.out.println("    j = " + j);
				System.out.println("      se(A["+j+"] > A["+(j+1)+"])");
				if(this.array.get(j) > this.array.get(j+1)) {
					int aux = this.array.get(j);
					System.out.println("        aux("+aux+") = A["+j+"]("+this.array.get(j)+")");
					this.array.set(j, this.array.get(j+1));
					System.out.println("        A["+(j)+"] = A["+(j+1)+"]("+this.array.get(j+1)+")");
					this.array.set(j+1, aux);
					System.out.println("        A["+(j+1)+"] = aux("+aux+")");
					System.out.println("                            " + this.listar());
					System.out.println("---------------------------");
				}else {
					System.out.println("      False");
					System.out.println("                             " + this.listar());
					System.out.println("---------------------------");
				}

			}
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
