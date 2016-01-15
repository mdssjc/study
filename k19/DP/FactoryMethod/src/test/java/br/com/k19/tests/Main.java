package br.com.k19.tests;

import br.com.k19.creator.Creator;
import br.com.k19.creator.concrete.EmissorCreator;
import br.com.k19.product.Emissor;

/**
 * Design Pattern
 * Creational - Factory Method (Virtual Constructor)
 *
 * @author mdssjc
 *
 */
public class Main {

    private static final String MENSAGEM = "K19 Treinamentos";

    public static void main(String[] args) {
        Creator creator = new EmissorCreator();

        Emissor emissor1 = creator.create(EmissorCreator.SMS);
        emissor1.envia(MENSAGEM);

        Emissor emissor2 = creator.create(EmissorCreator.EMAIL);
        emissor2.envia(MENSAGEM);

        Emissor emissor3 = creator.create(EmissorCreator.JMS);
        emissor3.envia(MENSAGEM);
    }
}
