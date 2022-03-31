package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ThreadArquivo extends Thread {
 
	private Semaphore semaphore;
	private int name;
	private File arquivo;
	FileWriter fw;
	BufferedWriter bw;
	
	public ThreadArquivo(int name, Semaphore semaphore, File arquivo, FileWriter fw, BufferedWriter bw) {
		this.name = name;
		this.semaphore = semaphore;
		this.arquivo = arquivo;
		this.fw = fw;
		this.bw = bw;
	}
	
	private void processar() {
		try {
			System.out.println("Thread #" + name + " processando.");
			Thread.sleep(300);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void regiaoNaoCritica() {
		System.out.println("Thread #" + name + " entrando em região não crítica.");
		processar();
	}
	
	private void escreverArquivo() {
		try {
			bw.append("Thread#" + name + " - ");
			System.out.println("Thread #" + name + " escreveu no arquivo.");
			processar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		regiaoNaoCritica();
		try {
			semaphore.acquire();
			escreverArquivo();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
	
}
