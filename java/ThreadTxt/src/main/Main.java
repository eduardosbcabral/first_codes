package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Semaphore s = new Semaphore(1);
		
		int processos = 10;
		
		File arquivoTxt = new File("C:\\Progs_no_install\\eclipse\\ThreadTxt\\arquivo\\arquivo.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			arquivoTxt.createNewFile();
			fw = new FileWriter(arquivoTxt);
			bw = new BufferedWriter(fw);
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		ThreadArquivo[] threads = new ThreadArquivo[processos];
		
		for(int i=0; i<processos; i++) {
			threads[i] = new ThreadArquivo(i, s, arquivoTxt, fw, bw);
			threads[i].start();
		}
		
		for(int i=0; i<processos; i++) {
			threads[i].join();
		}
		
		try {
			System.out.println("Threads finalizadas");
			bw.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}

	}
	
}
