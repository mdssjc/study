package br.com.k19.product.concrete;

import br.com.k19.product.Emissor;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class EmissorEmail implements Emissor {

    @Override
    public void envia(final String mensagem) {
        System.out.println("Enviando por E-mail a mensagem:");
        System.out.println(mensagem);
    }
}
