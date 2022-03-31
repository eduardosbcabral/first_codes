package ex3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ex3 {

	public static void main(String[] args) {
		
		ArrayList<String> codes = new ArrayList<String>();
		
		String fullCode = "";
		String codeWithoutComment = "";
		String code = "";
		String phrase = "";
		Boolean insideComment = false;
		Boolean insideBlockComment = false;
		Boolean insideLineComment = false;
		Boolean finalBlock = false;

		code = JOptionPane.showInputDialog("Digite a primeira linha do c�digo: ");
		
		while (!code.equals("stop")) {
			code = code + " ";
			codes.add(code);
			code = JOptionPane.showInputDialog("Digite a linha do c�digo (stop para parar): ");
		}
		
		for(int i=0; i<codes.size(); i++) {	
			
			phrase = "";	
			
			for(int j=0; j<codes.get(i).length();j++) {
				if(codes.get(i).charAt(j)=='/') {
					if(codes.get(i).charAt(j+1)=='*') {
						codeWithoutComment += phrase + "\n";
						insideBlockComment = true;
						insideComment = true;
					}
					if(codes.get(i).charAt(j+1)=='/') {
						insideLineComment = true;
						insideComment = true;
					}
				}
				
				if(codes.get(i).charAt(j)=='*' && insideBlockComment) {
					if(codes.get(i).charAt(j+1)=='/') {
						finalBlock = true;
					}
				}
				
				if(!insideComment)
					phrase += codes.get(i).charAt(j);
			}
			
			if(!insideComment) {
				codeWithoutComment += phrase + "\n";
			}
			
			if(insideComment && insideLineComment) {
				System.out.println("Entrou resetar linha");
				insideLineComment = false;
				insideComment = false;
				codeWithoutComment += phrase + "\n";
			}
			
			if(finalBlock) {
				System.out.println("Entrou resetar bloco");
				insideBlockComment = false;
				insideComment = false;
				finalBlock = false;
				codeWithoutComment += phrase + "\n";
			}
			
			fullCode += codes.get(i) + "\n";
		}

		JOptionPane.showMessageDialog(null,"C�digo completo: \n" + fullCode);
		JOptionPane.showMessageDialog(null,"C�digo sem coment�rios: \n" + codeWithoutComment);

	}

}
