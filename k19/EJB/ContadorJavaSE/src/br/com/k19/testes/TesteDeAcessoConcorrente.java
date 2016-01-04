package br.com.k19.testes;

import br.com.k19.sessionbeans.Contador;
import br.com.k19.utils.LookupFactory;

public class TesteDeAcessoConcorrente {

    public static void main(String[] args) throws Exception {
        final Contador contador = (Contador) LookupFactory.makeLookUp();
        final Thread[] threads = new Thread[20];

        System.out.println("Contador = " + contador.getValor());
        System.out.println(
                "Incrementando " + threads.length * threads.length + " vezes");
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < threads.length; j++) {
                    contador.incrementa();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("contador = " + contador.getValor());
    }
}
