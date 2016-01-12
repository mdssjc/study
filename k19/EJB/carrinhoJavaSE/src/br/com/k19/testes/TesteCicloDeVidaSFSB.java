package br.com.k19.testes;

import br.com.k19.sessionbeans.Carrinho;
import br.com.k19.utils.LookupFactory;

public class TesteCicloDeVidaSFSB {

    private static final int FIVE_SECONDS = 5000;
    private static final int ONE_SECOND   = 1000;

    public static void main(String[] args) throws Exception {
        Carrinho[] carrinhos = new Carrinho[6];

        for (int i = 0; i < carrinhos.length; i++) {
            carrinhos[i] = (Carrinho) LookupFactory.makeLookUp();
            carrinhos[i].adiciona("Chaveiro - K19");
            carrinhos[i].adiciona("Caneta - K19");
            Thread.sleep(ONE_SECOND);
        }

        carrinhos[0].adiciona("Borracha - K19");

        Thread.sleep(FIVE_SECONDS);

        carrinhos[0].finalizaCompra();
    }
}
