package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AFD01 extends Frame implements ActionListener {
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
	 AFD01() {super("AFD - Codigo da mercadoria");
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
	 if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " =   --> ");
		 Q = "q1"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco  --> ");
		 Q = "q0"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " >   --> ");
		 Q = "q2"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " <  --> ");
		 Q = "q2"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q13";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q13";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q0")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q13";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q1-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q1"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " = --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " > --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " < --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 -->");
		 Q = "q3";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q3";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q1")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q3";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q2-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q11";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " > --> ");
		 Q = "q13";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " < --> ");
		 Q = "q13";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " = --> ");
		 Q = "q1"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q2")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q3-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q7"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " >   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " <  --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " =   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q3")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q4"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q4-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q7"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " >   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " <  --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " =   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q5";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q5";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q4")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q5"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q5-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q7"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " >   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " <  --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " =   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q6";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q5")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q6"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q6-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q7";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " >   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " <  --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " =   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q12";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q12";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q6")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q12"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q7-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q7")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q7"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q7")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q8"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q7")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q8";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q7")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q9"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q7")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q9"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q8-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q8")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q0"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q8")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q8")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q9-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase(">")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " >   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("<")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " <  --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " =   --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q10"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q10"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q9")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q10-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q10")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q0";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q10")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q10")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q11-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q11"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " = --> ");
		 Q = "q14"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q3";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q3";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q11")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q3"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q12-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco >>> ");
		 Q = "q7"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q13"; 
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q13";
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q12")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q13-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase(" ")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " Espaço em branco --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("E")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " E --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("e")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " e --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("U")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " U --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("u")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " u --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("O")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " O --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("o")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " o --> ");
		 Q = "q13"; 
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("0")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 0 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("1")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 1 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("2")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 2 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("3")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 3 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("4")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 4 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("5")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 5 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("6")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 6 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("7")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 7 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("8")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 8 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 else if ( (vPrimitivaLida.equalsIgnoreCase("9")) && (Q.equalsIgnoreCase("q13")) ) {
		 mtxtExecucao.append(Q + " x " + " 9 --> ");
		 Q = "q13"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	 
	 /* -----------------------------INICIO DO ESTADO Q14-------------------------------*/
	 
	 else if ( (vPrimitivaLida.equalsIgnoreCase("=")) && (Q.equalsIgnoreCase("q14")) ) {
		 mtxtExecucao.append(Q + " x " + " = --> ");
		 Q = "q14"; // estado é o mesmo...
		 mtxtExecucao.append(Q + vEnter);
	 }
	
	 
	 
	 
	//======>>> ALUNO !!!! CODIFICAR AQUI O RESTANTE DO AFD !!!!!
	 }
	//---> Sentença foi aceita ?
	 mtxtExecucao.append(vEnter + "-----------------------------------" + vEnter);
	 if (Q.equalsIgnoreCase("q3") || Q.equalsIgnoreCase("q4") || Q.equalsIgnoreCase("q5") || Q.equalsIgnoreCase("q6") || Q.equalsIgnoreCase("q12")) {
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
	 new AFD01();
	 }
}


