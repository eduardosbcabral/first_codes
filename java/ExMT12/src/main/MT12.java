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

public class MT12 extends Frame implements ActionListener {
	int mLargura = 500;
	FlowLayout mFL = new FlowLayout(FlowLayout.CENTER);
	Panel mPainel1;
	Panel mPainel2;
	Panel mPainel3;
	Panel mPainel4;
	Panel mPainel5;
	Panel mPainel6;
	Panel mPainel7;
	Label mLbSentenca;
	TextField mSentenca;
	Button mBtExecutar;
	TextArea mtxtExecucao;
	TextArea mtxtProcessamento;
	Label mLbSQL;
	Button mBtFim;
	//---> Estruturas b�sicas para a MT
	String mFita = "";
	int mTamanhoFita = 0;
	int mPrimitivaASerProcessada = -1;
	String mQ = "";
	//---> Contador de processamento
	int mContadorProcessamento;
	//---> Construtor da Classe MT01 ...
	MT12() {
		super("M�quina de Turing para senten�as com igual quantidade de bits 0 e 1");
		//------> Desenhar "lay-out" da tela...
		mPainel1 = new Panel();
		mPainel2 = new Panel();
		mPainel3 = new Panel();
		mPainel4 = new Panel();
		mPainel5 = new Panel();
		mPainel6 = new Panel();
		mPainel7 = new Panel();
		mLbSentenca = new Label("Digite abaixo a senten�a desejada (entre # e $)");
		mSentenca = new TextField(50);
		mBtExecutar = new Button("Executar Passo a Passo");
		mtxtExecucao = new TextArea("Execu��o");
		mtxtProcessamento = new TextArea("Processamento da senten�a...");
		mLbSQL = new Label(">>> A senten�a � aceita ou n�o pela MT ? <<<");	
		mBtFim = new Button("Fim");
		//------> Disposi��o dos pain�is...
		mPainel1.setLocation(0,0);
		mPainel1.setBackground(new Color(255,128,128));
		mPainel1.setSize(mLargura,50);
		mPainel1.add(mLbSentenca);
		add(mPainel1);
		//
		mPainel2.setLocation(0,50);
		mPainel2.setBackground(new Color(255,255,255));
		mPainel2.setSize(mLargura,50);
		mPainel2.add(mSentenca);
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
		mPainel5.setLocation(0,350);
		mPainel5.setBackground(new Color(255,0,0));
		mPainel5.setSize(mLargura,150);
		mPainel5.add(mtxtProcessamento);
		add(mPainel5);
		//
		mPainel6.setLocation(0,500);
		mPainel6.setBackground(new Color(255,128,128));
		mPainel6.setSize(mLargura,50);
		mPainel6.add(mLbSQL);
		add(mPainel5);
		//
		mPainel7.setLocation(0,550);
		mPainel7.setBackground(new Color(255,128,255));
		mPainel7.setSize(mLargura,50);
		mPainel7.add(mBtFim);
		add(mPainel7);
		mBtFim.addActionListener(this);
		//------> Mostar janela
		this.resize(mLargura,600);
		mFL.setHgap(100);
		this.setLayout(mFL);
		this.show();
	}
	//----------------------------------------------------------
	//---> Processamento de Sentenca pela MT
	//----------------------------------------------------------
	public void fProcessamentoPelaMT() {
		String vPrimitivaLida;
		String vEnter = String.valueOf((char)13) + String.valueOf((char)10);
		String vAux;
		int vContAux;
		//---
		if ( (mFita.length() == 0) && (mSentenca.getText().length() > 0) ) {
			mFita = mSentenca.getText(); // copia a senten�a digitada na tela na fita da MT...
			mTamanhoFita = mFita.length();
			mPrimitivaASerProcessada = 0; // �ndice da primitiva na fita a ser processada...
			mContadorProcessamento = 0; // apenas para mostrar na tela...
			//------> Estado inicial da m�quina MT
			mQ = "q0";
			mtxtExecucao.setText("INICIO DO PROCESSAMENTO" + vEnter + "=========================" +
					vEnter);
			//---
			mtxtProcessamento.setText("CONFIGURA��O DA SENTEN�A" + vEnter + "========================="
					+ vEnter);
		}
		//---> Tem primitiva na fita para ser processada ?
		if ( (mPrimitivaASerProcessada < mTamanhoFita) && (mTamanhoFita > 0) ) {
			vPrimitivaLida = mFita.substring(mPrimitivaASerProcessada,mPrimitivaASerProcessada+1);
			mContadorProcessamento++;
			vContAux = 1000 + mContadorProcessamento;
			vAux = String.valueOf(vContAux);
			vAux = vAux.substring(1,4);
			mtxtExecucao.append("processamento " + vAux + ") ");
			//---
			if ( (mQ.equalsIgnoreCase("q0")) && (vPrimitivaLida.equalsIgnoreCase("#")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x # x D >>> ");
				mQ = "q1";
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q1")) && (vPrimitivaLida.equalsIgnoreCase("a")) ) {
				fGravaNaFita("1");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x a x D >>> ");
				mQ = "q2"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("1")) ) {
				fGravaNaFita("1");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 1 x D >>> ");
				mQ = "q3"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q2")) && (vPrimitivaLida.equalsIgnoreCase("a")) ) {
				fGravaNaFita("1");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x a x D >>> ");
				mQ = "q3"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}

			else if ( (mQ.equalsIgnoreCase("q3")) && (vPrimitivaLida.equalsIgnoreCase("a")) ) {
				fGravaNaFita("1");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x a x D >>> ");
				mQ = "q4"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			//Come�o do recursivo Q4
			else if ( (mQ.equalsIgnoreCase("q4")) && (vPrimitivaLida.equalsIgnoreCase("a")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x a x D >>> ");
				mQ = "q4"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q4")) && (vPrimitivaLida.equalsIgnoreCase("z")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x z x D >>> ");
				mQ = "q4"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q4")) && (vPrimitivaLida.equalsIgnoreCase("c")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x c x D >>> ");
				mQ = "q4"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q4")) && (vPrimitivaLida.equalsIgnoreCase("2")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 2 x D >>> ");
				mQ = "q4"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q4")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x D >>> ");
				mQ = "q4"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			//Fim do recursivo Q4
			
			else if ( (mQ.equalsIgnoreCase("q4")) && (vPrimitivaLida.equalsIgnoreCase("d")) ) {
				fGravaNaFita("2");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x d x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			//Come�o do recursivo q5
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("2")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 2 x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("a")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x a x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("d")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x d x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("c")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x c x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("c")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x c x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("z")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x z x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x E >>> ");
				mQ = "q5"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			//Fim do recursivo q5
			
			else if ( (mQ.equalsIgnoreCase("q5")) && (vPrimitivaLida.equalsIgnoreCase("a")) ) {
				fGravaNaFita("1");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x a x D >>> ");
				mQ = "q3"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			else if ( (mQ.equalsIgnoreCase("q3")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				fGravaNaFita("3");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x D >>> ");
				mQ = "q6";
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q6")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				fGravaNaFita("3");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x D >>> ");
				mQ = "q7"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q6")) && (vPrimitivaLida.equalsIgnoreCase("3")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 3 x D >>> ");
				mQ = "q7"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			else if ( (mQ.equalsIgnoreCase("q6")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x D >>> ");
				mQ = "q7"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			//Come�o do recursivo q7
			else if ( (mQ.equalsIgnoreCase("q7")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x D >>> ");
				mQ = "q7"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			else if ( (mQ.equalsIgnoreCase("q7")) && (vPrimitivaLida.equalsIgnoreCase("3")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 3 x D >>> ");
				mQ = "q7"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q7")) && (vPrimitivaLida.equalsIgnoreCase("4")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 4 x D >>> ");
				mQ = "q7"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			//Fim do recursivo q7
			
			else if ( (mQ.equalsIgnoreCase("q7")) && (vPrimitivaLida.equalsIgnoreCase("c")) ) {
				fGravaNaFita("4");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x c x D >>> ");
				mQ = "q8";
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			//Come�o do recursivo q8
			else if ( (mQ.equalsIgnoreCase("q8")) && (vPrimitivaLida.equalsIgnoreCase("z")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x z x E >>> ");
				mQ = "q8";
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}			
			
			else if ( (mQ.equalsIgnoreCase("q8")) && (vPrimitivaLida.equalsIgnoreCase("4")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 4 x E >>> ");
				mQ = "q8";
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}

			else if ( (mQ.equalsIgnoreCase("q8")) && (vPrimitivaLida.equalsIgnoreCase("c")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x c x E >>> ");
				mQ = "q8"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			else if ( (mQ.equalsIgnoreCase("q8")) && (vPrimitivaLida.equalsIgnoreCase("b")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x b x E >>> ");
				mQ = "q8"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada--;
			}
			//Fim do recursivo q8
			
			else if ( (mQ.equalsIgnoreCase("q8")) && (vPrimitivaLida.equalsIgnoreCase("c")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x c x D >>> ");
				mQ = "q6"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q8")) && (vPrimitivaLida.equalsIgnoreCase("3")) ) {
				fGravaNaFita("3");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 3 x D >>> ");
				mQ = "q6"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			else if ( (mQ.equalsIgnoreCase("q6")) && (vPrimitivaLida.equalsIgnoreCase("z")) ) {
				fGravaNaFita("5");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x z x D >>> ");
				mQ = "q9"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q6")) && (vPrimitivaLida.equalsIgnoreCase("4")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 4 x D >>> ");
				mQ = "q6"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q9")) && (vPrimitivaLida.equalsIgnoreCase("z")) ) {
				fGravaNaFita("5");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x z x D >>> ");
				mQ = "q10"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q10")) && (vPrimitivaLida.equalsIgnoreCase("z")) ) {
				fGravaNaFita("5");
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x z x D >>> ");
				mQ = "q9"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			else if ( (mQ.equalsIgnoreCase("q10")) && (vPrimitivaLida.equalsIgnoreCase("2")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 2 x D >>> ");
				mQ = "q11"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}

			
			else if ( (mQ.equalsIgnoreCase("q11")) && (vPrimitivaLida.equalsIgnoreCase("2")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x 2 x D >>> ");
				mQ = "q11"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q10")) && (vPrimitivaLida.equalsIgnoreCase("$")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x $ x D >>> ");
				mQ = "q12"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			else if ( (mQ.equalsIgnoreCase("q11")) && (vPrimitivaLida.equalsIgnoreCase("$")) ) {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x $ x D >>> ");
				mQ = "q12"; // estado � o mesmo...
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
			else {
				mtxtExecucao.append(mQ + " x " + vPrimitivaLida + " x ? >>> ");
				mQ = "qE"; // erro... programa��o inexistente
				mtxtExecucao.append(mQ + vEnter);
				fDesenhaSentenca();
				mPrimitivaASerProcessada++;
			}
			
		}
		//---> Senten�a foi aceita ?
		if (mPrimitivaASerProcessada >= mTamanhoFita) {
			mPrimitivaASerProcessada = -1; // para n�o entrar mais neste if...
			mtxtExecucao.append(vEnter + "-----------------------------------" + vEnter);
			if (mQ.equalsIgnoreCase("q12")) {
				mtxtExecucao.append("Senten�a ACEITA !!! " + vEnter);
			}
			else {
				mtxtExecucao.append("Senten�a REJEITADA !!! " + vEnter);
			}
			mtxtExecucao.append("-----------------------------------" + vEnter);
			mtxtExecucao.append(vEnter + "*** FIM ***" + vEnter);
			//---> Reiniciar o Bot�o do Passo a Passo
			mFita = "";
			mTamanhoFita = 0;
		}
	}
	//---------------------------------------------------------------------------
	//---> Gravar na Fita um s�mbolo auxiliar na posi��o mPrimitivaASerProcessada
	//---------------------------------------------------------------------------
	public void fGravaNaFita(String aSimboloAuxiliar) {
		String vFitaAux;
		vFitaAux = mFita.substring(0,mPrimitivaASerProcessada);
		vFitaAux += aSimboloAuxiliar + mFita.substring(mPrimitivaASerProcessada+1,mFita.length());
		//---> Atualiza Fita com senten�a em processamento...
		mFita = vFitaAux;
	}
	//----------------------------------------------------------------
	//---> Desenhar configura��o da senten�a ao longo do processamento
	//----------------------------------------------------------------
	public void fDesenhaSentenca() {
		String vEnter = String.valueOf((char)13) + String.valueOf((char)10);
		String vFitaAux;
		int vContAux;
		String vAux;
		vContAux = 1000 + mContadorProcessamento;
		vAux = String.valueOf(vContAux);
		vAux = vAux.substring(1,4);
		mtxtProcessamento.append("processamento " + vAux + ") ");
		vFitaAux = mFita.substring(0,mPrimitivaASerProcessada);
		mtxtProcessamento.append(vFitaAux);
		mtxtProcessamento.append("<<" + mFita.substring(mPrimitivaASerProcessada,mPrimitivaASerProcessada+1) +
				">>");
		vFitaAux = mFita.substring(mPrimitivaASerProcessada+1,mFita.length());
		mtxtProcessamento.append(vFitaAux);
		mtxtProcessamento.append(vEnter);
	}
	//-----------------------------------
	//---> Listener
	//-----------------------------------
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Fim") {
			System.exit(0);
		}
		if (e.getActionCommand() == "Executar Passo a Passo") {
			fProcessamentoPelaMT();
		}
	}
	//------------------------
	//---> Programa principal
	//------------------------
	public static void main(String[] args) {
		new MT12();
	}
}
