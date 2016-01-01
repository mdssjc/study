package br.com.k19.testes;

import br.com.k19.sessionbeans.LancadorDeDado;
import br.com.k19.utils.Recursos;

public class TesteCicloDeVidaSLSB {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            final LancadorDeDado lancadorDeDado = Recursos.getLancadorDeDado();

            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(lancadorDeDado.lanca());
                }
            }).start();
        }
    }
}
