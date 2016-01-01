package br.com.k19.testes;

import java.util.Map;
import java.util.concurrent.Future;

import br.com.k19.sessionbeans.LancadorDeDado;
import br.com.k19.utils.Recursos;

public class TesteAsynchronous {

    private static final int WAIT = 100;

    public static void main(String[] args) throws Exception {
        LancadorDeDado lancadorDeDado = Recursos.getLancadorDeDado();
        Future<Map<Integer, Integer>> future = lancadorDeDado.calculaFrequencia();

        System.out.println("Aguardando...");

        while (!future.isDone()) {
            System.out.println("*");
            Thread.sleep(WAIT);
        }
        System.out.println("\n" + future.get());
    }
}
