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
public class VisaComunicadorFactory implements ComunicadorFactory {

    private static final int OPERADORA       = Creator.VISA;
    private EmissorCreator   emissorCreator  = new EmissorCreator();
    private ReceptorCreator  receptorCreator = new ReceptorCreator();

    @Override
    public Emissor createEmissor() {
        return emissorCreator.create(OPERADORA);
    }

    @Override
    public Receptor createReceptor() {
        return receptorCreator.create(OPERADORA);
    }
}
