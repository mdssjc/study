package br.com.k19.product.concrete;

import br.com.k19.product.Receptor;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class ReceptorMastercard implements Receptor {

    @Override
    public String recebe() {
        System.out.println("Recebendo mensagem da Mastercard.");
        String mensagem = "Mensagem da Mastercard";
        return mensagem;
    }
}
