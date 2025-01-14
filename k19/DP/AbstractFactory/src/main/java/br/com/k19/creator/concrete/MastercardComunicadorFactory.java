package br.com.k19.creator.concrete;

import br.com.k19.creator.ComunicadorFactory;
import br.com.k19.creator.Creator;
import br.com.k19.product.Emissor;
import br.com.k19.product.Receptor;

/**
 * Concrete Creator Class
 *
 * @author mdssjc
 *
 */
public class MastercardComunicadorFactory implements ComunicadorFactory {

    private static final int      OPERADORA       = Creator.MASTERCARD;
    private final EmissorCreator  emissorCreator  = new EmissorCreator();
    private final ReceptorCreator receptorCreator = new ReceptorCreator();

    @Override
    public Emissor createEmissor() {
        return this.emissorCreator.create(
                MastercardComunicadorFactory.OPERADORA);
    }

    @Override
    public Receptor createReceptor() {
        return this.receptorCreator.create(
                MastercardComunicadorFactory.OPERADORA);
    }
}
