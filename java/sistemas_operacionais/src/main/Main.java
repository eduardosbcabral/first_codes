package main;

public class Main {

    public static void main(String[] args){
        ThreadApp thread1 = new ThreadApp("Primeira Thread");
        thread1.start();
        thread1.setPriority(5);                                         //Quanto maior o numero, maior será a prioridade ou a chance dela rodar primeiro
        ThreadApp thread2 = new ThreadApp("Segunda Thread");
        thread2.start();
        thread2.setPriority(10);                                         //Quanto maior o numero, maior será a prioridade ou a chance dela rodar primeiro
        ThreadApp thread3 = new ThreadApp("Terceira Thread");
        thread3.start();
        thread3.setPriority(1);                                         //Quanto maior o numero, maior será a prioridade ou a chance dela rodar primeiro
    }

}
