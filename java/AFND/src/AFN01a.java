import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class AFN01a extends Frame implements ActionListener {
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
	TextArea mtxtCaminhos;
	Label mLbSQL;
	Button mBtFim;
	//---> Principais Estruturas de dados para o AFN e seu processamento
	ArrayList mTransicoesAFN = new ArrayList();
	ArrayList mEstadosFinaisDoAFN = new ArrayList();
	ArrayList mCaminhos = new ArrayList();
	//---> Construtor da Classe AFN01a ...
	AFN01a() {
		super("AFN - Processamento de AFN");
		//------> Desenhar "lay-out" da tela...
		mPainel1 = new Panel();
		mPainel2 = new Panel();
		mPainel3 = new Panel();
		mPainel4 = new Panel();
		mPainel5 = new Panel();
		mPainel6 = new Panel();
		mPainel7 = new Panel();
		mLbSentenca = new Label("Digite abaixo a seneten�a desejada");
		mSentenca = new TextField(50);
		mBtExecutar = new Button("Executar");
		mtxtExecucao = new TextArea("Execu��o");
		mtxtCaminhos = new TextArea("Caminhos ao final do processamento");
		mLbSQL = new Label(">>> A senten�a � aceita ou n�o pelo AF ? <<<");
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
		mPainel5.add(mtxtCaminhos);
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
		//------> Definir os estado finais do AFN
		fDefinirEstadosFinaisDoAFN();
		//------> Definir as transi��es do AFN ("desenhar" o grafo do aut�mato)
		fDefinirTransicoesDoAFN();
	}
	//----------------------------------------------------------
	//---> Implementa��o do AFN
	//===> Indicar aqui os estados finais do AFN...
	//----------------------------------------------------------
	private void fDefinirEstadosFinaisDoAFN() {
		mEstadosFinaisDoAFN.add("q4");
		//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		//---> ALUNO: complete aqui os estados finais do AF
		//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
	}
	//----------------------------------------------------------
	//---> Implementa��o do AFN
	//===> Criar aqui o AFN propriamente dito...
	//----------------------------------------------------------
	private void fDefinirTransicoesDoAFN() {
		CTransicao vTransicao;
		vTransicao = new CTransicao();
		vTransicao.fSetEstado("q0");
		vTransicao.fSetPrmitiva("0");
		vTransicao.fSetNovoEstado("q10");
		mTransicoesAFN.add(vTransicao);
		//---
		vTransicao = new CTransicao();
		vTransicao.fSetEstado("q0");
		vTransicao.fSetPrmitiva("0");
		vTransicao.fSetNovoEstado("q14");
		mTransicoesAFN.add(vTransicao);
		//---
		vTransicao = new CTransicao();
		vTransicao.fSetEstado("q0");
		vTransicao.fSetPrmitiva("1");
		vTransicao.fSetNovoEstado("q1");
		mTransicoesAFN.add(vTransicao);
		//---
		vTransicao = new CTransicao();
		vTransicao.fSetEstado("q0");
		vTransicao.fSetPrmitiva("1");
		vTransicao.fSetNovoEstado("q1");
		mTransicoesAFN.add(vTransicao);
		//---
		//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		//---> ALUNO: complete aqui as transi��es do AF
		//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
	}
	//----------------------------------------------------------
	//---> Processamento de Sentenca pelo AFN
	//----------------------------------------------------------
	public void fProcessamentoPeloAFN() {
		String vFita = mSentenca.getText();
		int vTamanhoFita = vFita.length();
		int iCursor;
		String vPrimitivaLida;
		String Q;
		CNoProc vNoProc;
		int indNoAtual;
		int indProximoNo; // � o n� que na lista ser� processado com a pr�xima primitiva lida...
		int indInicioDosResultados; // a partir deste n�, os estados s�o os estados dos
		// caminhos ao final do processamento das primitivas
		String vEstadoProc;
		CTransicao vTransicao;
		int k;
		String vEstado;
		String vPrimitiva;
		String vNovoEstado;
		String vEnter = String.valueOf((char)13) + String.valueOf((char)10);
		String vAux;
		String vEhQerro;
		mtxtExecucao.setText("INICIO DO PROCESSAMENTO" + vEnter +
				"=========================" + vEnter);
		mCaminhos.clear(); // "limpar" para iniciar um novo processamento...
		//---> Estado inicial da m�quina AFN
		Q = "q0";
		vNoProc = new CNoProc();
		vNoProc.fSetEstadoProc(Q); // estado atual de processamento
		vNoProc.fSetIndiceNoPai(-1); // N�-raiz n�o tem n� pai...
		mCaminhos.add(vNoProc);
		indNoAtual = 0; // � o n� que atualmente est� em processamento...
		indProximoNo = indNoAtual + 1; // Pr�ximo n� a ser processado com a pr�xima primitiva lida
		indInicioDosResultados = indNoAtual;
		//---> loop para processar a fita...
		for (iCursor = 0; iCursor < vTamanhoFita; iCursor++) {
			vPrimitivaLida = vFita.substring(iCursor,iCursor+1);
			vAux = String.valueOf(iCursor+1);
			vAux = "Primitiva " + vAux + " = " + vPrimitivaLida;
			mtxtExecucao.append("-------------------------------------------" + vEnter);
			mtxtExecucao.append(vAux + vEnter + vEnter);
			//------> Processamento de todos os estados dispon�veis para a primitiva em quest�o...
			while (indNoAtual < indProximoNo) {
				vNoProc = (CNoProc)mCaminhos.get(indNoAtual);
				vEstadoProc = vNoProc.fGetEstadoProc(); // � o estado atual de processamento...
				vAux = vEstadoProc + " x " + vPrimitivaLida + " -> ";
				vEhQerro = "S"; // em princ�pio sup�e-se que n�o tem transi��o (ou seja, qE)..
				//---------> Avalia toda a lista de transi��es do AFN...
				for (k = 0; k < mTransicoesAFN.size(); k++) {
					vTransicao = (CTransicao)mTransicoesAFN.get(k);
					vEstado = vTransicao.fGetEstado();
					vPrimitiva = vTransicao.fGetPrimitiva();
					if ( (vEstadoProc.equalsIgnoreCase(vEstado)) &&
							(vPrimitivaLida.equalsIgnoreCase(vPrimitiva)) ) {
						vNovoEstado = vTransicao.fGetNovoEstado();
						vNoProc = new CNoProc();
						vNoProc.fSetEstadoProc(vNovoEstado);
						vNoProc.fSetIndiceNoPai(indNoAtual);
						mCaminhos.add(vNoProc);
						vAux += " " + vNovoEstado + " ou ";
						vEhQerro = "N";
					}
				} // pr�xima transi��o da lista de transi��es do AFN
				if (vEhQerro.equalsIgnoreCase("N")) {
					vAux = vAux.substring(0,vAux.length()-4);
				}
				else {
					vAux += " qE";
				}
				mtxtExecucao.append(vAux + vEnter);
				indNoAtual++; // Pr�ximo estado a ser avaliada com a primitiva lida
				indInicioDosResultados = indNoAtual;
			}
			indProximoNo = mCaminhos.size();
		} // pr�xima primitiva a ser lida...
		mtxtExecucao.append(vEnter + "====================" + vEnter + " FIM " + vEnter);
		//---> A variavel indInicioDosResultados marca os n�s (at� o final da lista mCaminhos)
		//---> que s�o os estados dos caminhos ao t�rmino da leitura da fita de entrada..
		fMostrarCaminhos(indInicioDosResultados);
	}
	//----------------------------------------------------------
	//---> Mostrar os caminhos processados pelo AFN
	//----------------------------------------------------------
	private void fMostrarCaminhos(int aindInicioDosEstados) {
		String vFita = mSentenca.getText();
		String vEnter = String.valueOf((char)13) + String.valueOf((char)10);
		mtxtCaminhos.setText("CAMINHOS CONSTRU�DOS PELO AFN" + vEnter +
				"=================================" + vEnter);
		//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
		//---> ALUNO: implemente aqui a rotina de apresenta��o dos caminhos gerados pelo AF
		//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
	}
	//----------------------------------------------------------
	//---> Verificar se � estado final
	//----------------------------------------------------------
	private String fVerificaSeEhEstadoFinal(String aEstadoProc) {
		String vEhEstadoFinal = "N";
		int k;
		String vEstadoFinal;
		for(k = 0; k < mEstadosFinaisDoAFN.size(); k++) {
			vEstadoFinal = (String)mEstadosFinaisDoAFN.get(k);
			if (vEstadoFinal.equalsIgnoreCase(aEstadoProc)) {
				vEhEstadoFinal = "S";
			}
		}
		return vEhEstadoFinal;
	}
	//-----------------------------------
	//---> Listener
	//-----------------------------------
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Fim") {
			System.exit(0);
		}
		if (e.getActionCommand() == "Executar") {
			fProcessamentoPeloAFN();
		}
	}
	//------------------------
	//---> Programa principal
	//------------------------
	public static void main(String[] args) {
		new AFN01a();
	}
}
//===================================
//Classe para o objeto Transi��o
//===================================
class CTransicao {
	String mEstado;
	String mPrimitiva;
	String mNovoEstado;
	CTransicao() { }
	public void fSetEstado(String aValor) { mEstado = aValor; }
	public void fSetPrmitiva(String aValor) { mPrimitiva = aValor; }
	public void fSetNovoEstado(String aValor) { mNovoEstado = aValor; }
	public String fGetEstado() { return mEstado; }
	public String fGetPrimitiva() { return mPrimitiva; }
	public String fGetNovoEstado() { return mNovoEstado; }
}
//=======================================================================
//Classe para o objeto-elemento "N� de processamento" da lista mCaminhos
//=======================================================================
class CNoProc {
	String mEstadoProc;
	int mIndiceNoPai;
	CNoProc() { }
	public void fSetEstadoProc(String aValor) { mEstadoProc = aValor; }
	public void fSetIndiceNoPai(int aValor) { mIndiceNoPai = aValor; }
	public String fGetEstadoProc() { return mEstadoProc; }
	public int fGetIndiceNoPai() { return mIndiceNoPai; }
}

