package main;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AFD15 extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int mLargura = 500;
	FlowLayout mFL = new FlowLayout(FlowLayout.CENTER);
	Panel mPainel1;
	Panel mPainel2;
	Panel mPainel3;
	Panel mPainel4;
	Panel mPainel5;
	Label mLbFita;
	TextField mFita;
	Button mBtExecutar;
	TextArea mtxtExecucao;
	Button mBtFim;
	//---> Construtor da Classe AFD01 ...
	AFD15() { super("AFD - Codigo da mercadoria");
	//------> Desenhar "lay-out" da tela...
	mPainel1 = new Panel();
	mPainel2 = new Panel();
	mPainel3 = new Panel();
	mPainel4 = new Panel();
	mPainel5 = new Panel();
	mLbFita = new Label("Digite abaixo a sentença desejada");
	mFita = new TextField(50);
	mBtExecutar = new Button("Executar");
	mtxtExecucao = new TextArea("Execução");
	mBtFim = new Button("Fim");
	//------> Disposição dos painéis...
	mPainel1.setLocation(0,0);
	mPainel1.setBackground(new Color(255,128,128));
	mPainel1.setSize(mLargura,50);
	mPainel1.add(mLbFita);
	add(mPainel1);
	//
	mPainel2.setLocation(0,50);
	mPainel2.setBackground(new Color(255,255,255));
	mPainel2.setSize(mLargura,50);
	mPainel2.add(mFita);
	add(mPainel2);
	//
	mPainel3.setLocation(0,100);
	mPainel3.setBackground(new Color(255,128,128));
	mPainel3.setSize(mLargura,50);
	mPainel3.add(mBtExecutar);
	add(mPainel3);
	mBtExecutar.addActionListener(this);
	//
	mPainel4.setLocation(0,150);
	mPainel4.setBackground(new Color(0,255,0));
	mPainel4.setSize(mLargura,150);
	mPainel4.add(mtxtExecucao);
	add(mPainel4);
	//
	mPainel5.setLocation(0,550);
	mPainel5.setBackground(new Color(255,128,255));
	mPainel5.setSize(mLargura,50);
	mPainel5.add(mBtFim);
	add(mPainel5);
	mBtFim.addActionListener(this);
	//------> Mostar janela
	this.resize(mLargura,600);
	mFL.setHgap(100);
	this.setLayout(mFL);
	this.show();
	}
	//----------------------------------------------------------
	//---> Processamento de Sentenca pelo AFD
	//----------------------------------------------------------
	public void fProcessamentoPeloAFD() {
		int vTamanhoFita = mFita.getText().length();
		int iCursor;
		String vPrimitivaLida;
		String Q;
		String vEnter = String.valueOf((char)13) + String.valueOf((char)10);
		String vAux;
		//---> loop para processar a fita...
		Q = "q0";
		mtxtExecucao.setText("INICIO DO PROCESSAMENTO" + vEnter +
				"=========================" + vEnter);
		for (iCursor = 0; iCursor < vTamanhoFita; iCursor++) {
			vPrimitivaLida = mFita.getText().substring(iCursor,iCursor+1);
			
			//Começo do prefixo
			if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q0")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q1";
				mtxtExecucao.append(Q + vEnter);
			}
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q2"; 
				mtxtExecucao.append(Q + vEnter);
			}
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q2")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q3";
				mtxtExecucao.append(Q + vEnter);
			}
			//Término do prefixo
			
			//Começo do recursivo Q3
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q3";
				mtxtExecucao.append(Q + vEnter);
			}
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q3";
				mtxtExecucao.append(Q + vEnter);
			}
			//Término do recursivo Q3
			
			//Começo da substring
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q4";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q3";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q5";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q4";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q3";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q10";
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Começo do recursivo Q10
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q10")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q10";
				mtxtExecucao.append(Q + vEnter);
			}
			//Término do recursivo Q10
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q10")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q4";
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término da substring
			
			//Começo do recursivo Q6
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término do recursivo Q6
			
			//Começo do sufixo
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q7";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Começo do recursivo Q7
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q7";
				mtxtExecucao.append(Q + vEnter);
			}
			//Término do recursivo Q7
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q8";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q7";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q9";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q7";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("b")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "b >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("c")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "c >>> ");
				Q = "q6";
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("a")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "a >>> ");
				Q = "q7";
				mtxtExecucao.append(Q + vEnter);
			}
			//Término do sufixo
		}
		//---> Sentença foi aceita ?
		mtxtExecucao.append(vEnter + "-----------------------------------" + vEnter);
		if (Q.equalsIgnoreCase("Q9")) {
			mtxtExecucao.append("Sentença ACEITA !!!" + vEnter);
		}
		else {
			mtxtExecucao.append("Sentença REJEITADA !!!" + vEnter);
		}
		mtxtExecucao.append("-----------------------------------" + vEnter);
		mtxtExecucao.append(vEnter + "*** FIM ***" + vEnter);
	}
	//-----------------------------------
	//---> Listener
	//-----------------------------------
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Fim") {
			System.exit(0);
		}
		if (e.getActionCommand() == "Executar") {
			fProcessamentoPeloAFD();
		}
	}
	//------------------------
	//---> Programa principal
	//------------------------
	public static void main(String[] args) {
		new AFD15();
	}
}	