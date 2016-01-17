package br.com.k19.product.concrete;

import br.com.k19.product.Emissor;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class EmissorMastercard implements Emissor {

    @Override
    public void envia(final String mensagem) {
        System.out.println("Enviando a seguinte mensagem para a Mastercard:");
        System.out.println(mensagem);
    }
}
