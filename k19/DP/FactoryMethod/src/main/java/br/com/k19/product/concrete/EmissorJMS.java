package br.com.k19.product.concrete;

import br.com.k19.product.Emissor;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class EmissorJMS implements Emissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando por JMS a mensagem:");
        System.out.println(mensagem);
    }
}
