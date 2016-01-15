package br.com.k19.product.concrete;

import br.com.k19.product.Receptor;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class ReceptorVisa implements Receptor {

    @Override
    public String recebe() {
        System.out.println("Recebendo mensagem da Visa.");
        String mensagem = "Mensagem da Visa";
        return mensagem;
    }
}
