package br.com.k19.product.concrete;

import br.com.k19.product.Emissor;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class EmissorVisa implements Emissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando a seguinte mensagem para a Visa:");
        System.out.println(mensagem);
    }
}
