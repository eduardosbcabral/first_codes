package ex4;

import javax.swing.JOptionPane;

public class Ex4 {
    
	public static void main(String[] args) {

		String code = JOptionPane.showInputDialog("Digite o código: ");
	
		Regex regex = new Regex();
		

		if(regex.checkIfCommentIsRight(code))
			return;
		
		if(regex.verifyWrongSL(code))
			return;
	   
		if(regex.verifyWrongBL(code))
			return;
	}

}
