package br.com.k19.testes;

import br.com.k19.sessionbeans.LancadorDeDado;
import br.com.k19.utils.Recursos;

public class TesteDeAcesso {

    public static void main(String[] args) throws Exception {
        LancadorDeDado lancadorDeDado = Recursos.getLancadorDeDado();
        System.out.println(lancadorDeDado.lanca());
    }
}
