package br.com.k19.tests;

import br.com.k19.creator.ComunicadorFactory;
import br.com.k19.creator.concrete.MastercardComunicadorFactory;
import br.com.k19.creator.concrete.VisaComunicadorFactory;
import br.com.k19.product.Emissor;
import br.com.k19.product.Receptor;

/**
 * Design Pattern
 * Creational - Abstract Factory (Kit)
 *
 * @author mdssjc
 *
 */
public class Main {

    public static void main(String[] args) {
        /* VISA */
        ComunicadorFactory comunicadorFactory = new VisaComunicadorFactory();

        String transacao = "Valor=560;Senha=123";
        Emissor emissor = comunicadorFactory.createEmissor();
        emissor.envia(transacao);

        Receptor receptor = comunicadorFactory.createReceptor();
        String mensagem = receptor.recebe();
        System.out.println(mensagem);

        /* MASTERCARD */
        comunicadorFactory = new MastercardComunicadorFactory();

        transacao = "Valor=380;Senha=abc";
        emissor = comunicadorFactory.createEmissor();
        emissor.envia(transacao);

        receptor = comunicadorFactory.createReceptor();
        mensagem = receptor.recebe();
        System.out.println(mensagem);
    }
}
