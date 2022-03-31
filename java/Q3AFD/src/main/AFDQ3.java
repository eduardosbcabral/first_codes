package main;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AFDQ3 extends Frame implements ActionListener {
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
	AFDQ3() { super("AFD - Codigo da mercadoria");
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
			
			//Começo dos símbolos
			if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q0")) ) {
				mtxtExecucao.append(Q + " x " + "< >>> ");
				Q = "q1";
				mtxtExecucao.append(Q + vEnter);
			}
			else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q0")) ) {
				mtxtExecucao.append(Q + " x " + "> >>> ");
				Q = "q1"; 
				mtxtExecucao.append(Q + vEnter);
			}
			else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q0")) ) {
				mtxtExecucao.append(Q + " x " + "= >>> ");
				Q = "q3"; 
				mtxtExecucao.append(Q + vEnter);
			}
			else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "= >>> ");
				Q = "q2"; 
				mtxtExecucao.append(Q + vEnter);
			}
			//Término dos símbolos
			
			//Começo dos espaços em branco
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q3"; 
				mtxtExecucao.append(Q + vEnter);
			}
			//Recursivo Q3
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q3"; 
				mtxtExecucao.append(Q + vEnter);
			}
			//Término recursivo Q3
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q2")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q3"; 
				mtxtExecucao.append(Q + vEnter);
			}
			//Término dos espaços em branco
			
			//Começo dos números
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q1")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos números 1
			
			//Começo dos números 2
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q3")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q4"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos números 2
			
			//Começo dos números 3
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			//Término dos números 3
			
			//Começo dos números 4
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q5"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos números 3
			
			//Começo dos números 4
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q6"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos números 4
			
			//Começo dos números 5
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q7"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos números 5
			
			//Começo dos números 6
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q8"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos números 6
			
			//Começo dos espaços em branco depois do número
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q4")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q9"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q5")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q9"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q6")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q9"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q7")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q9"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q9"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos espaços em branco depois do número
			
			//Começo do E
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "E >>> ");
				Q = "q10"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "e >>> ");
				Q = "q9"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término do E
			
			//Começo do OU
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "O >>> ");
				Q = "q11"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q9")) ) {
				mtxtExecucao.append(Q + " x " + "o >>> ");
				Q = "q11"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q11")) ) {
				mtxtExecucao.append(Q + " x " + "U >>> ");
				Q = "q12"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q11")) ) {
				mtxtExecucao.append(Q + " x " + "u >>> ");
				Q = "q12"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término do OU
			
			//Começo dos espaços depois do OU e E
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q10")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q13"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q12")) ) {
				mtxtExecucao.append(Q + " x " + "espaço em branco >>> ");
				Q = "q13"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término dos espaços depois do OU e E
			
			//Começo da volta do < > =
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q13")) ) {
				mtxtExecucao.append(Q + " x " + "< >>> ");
				Q = "q1"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q13")) ) {
				mtxtExecucao.append(Q + " x " + "> >>> ");
				Q = "q1"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q13")) ) {
				mtxtExecucao.append(Q + " x " + "= >>> ");
				Q = "q3"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término da volta do < > =
			
			//Lixeira maior que 6 digitos
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q8")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			
			//Começo do recursivo Q15
			else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "0 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "1 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "2 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "3 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "4 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "5 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "6 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "7 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "8 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q15")) ) {
				mtxtExecucao.append(Q + " x " + "9 >>> ");
				Q = "q15"; 
				mtxtExecucao.append(Q + vEnter);
			}
			
			//Término do recursivo Q15
			
		}
		//---> Sentença foi aceita ?
		mtxtExecucao.append(vEnter + "-----------------------------------" + vEnter);
		if (Q.equalsIgnoreCase("Q4")||Q.equalsIgnoreCase("Q5")||Q.equalsIgnoreCase("Q6")||Q.equalsIgnoreCase("Q7")||Q.equalsIgnoreCase("Q8")) {
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
		new AFDQ3();
	}
}	