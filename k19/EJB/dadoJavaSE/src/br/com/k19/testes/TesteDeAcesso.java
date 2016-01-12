package br.com.k19.testes;

import br.com.k19.sessionbeans.LancadorDeDado;
import br.com.k19.utils.LookupFactory;

public class TesteDeAcesso {

    public static void main(String[] args) throws Exception {
        LancadorDeDado lancadorDeDado = (LancadorDeDado) LookupFactory.makeLookUp();
        System.out.println(lancadorDeDado.lanca());
    }
}
