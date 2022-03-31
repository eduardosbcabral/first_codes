package main;

import java.lang.Thread;

public class ThreadApp implements Runnable { // Implementar o runnable para a classe ter as mesmas propriedades e conseguir rodar thread nela
    Thread thread;
    private String name;

    public ThreadApp(String name) {
        this.name = name;
    }

    @Override
    public void run() { //Função da classe Thread que faz a thread rodar depois do start, é a primeira coisa que a thread procura na classe
        System.out.println("Thread [" + name + "] rodando");

        for(int i=0; i <= 20; i++){
            System.out.println("(" + i + ")" + " - [" + name + "]");

            /*try {
                Thread.sleep(1000); //Quando inserido o sleep, as threads por mais que concorrentes, rodam as mesmas coisas praticamente na mesma ordem
            }catch(InterruptedException e){
                System.out.println("Thread [" + name + "] interrompida.");
            }*/
        }
    }

    public void start() { //Função da classe para iniciar a thread
        if(thread == null) { // Verificar se a thread é null
            thread = new Thread(this, name); // Inicilizar a classe Thread passando a própria classe com runnable como parametro
            thread.start();
            System.out.println("Thread [" + name + "] iniciada.");
        }
    }

    public void setPriority(int num){ // SET para setar a prioridade da thread em questao
        this.thread.setPriority(num);
    }
}
