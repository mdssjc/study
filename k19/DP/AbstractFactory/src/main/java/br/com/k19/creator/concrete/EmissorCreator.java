package br.com.k19.creator.concrete;

import br.com.k19.creator.Creator;
import br.com.k19.product.Emissor;
import br.com.k19.product.concrete.EmissorMastercard;
import br.com.k19.product.concrete.EmissorVisa;

/**
 * Concrete Creator Class
 *
 * @author mdssjc
 *
 */
public class EmissorCreator implements Creator<Emissor> {

    @Override
    public Emissor create(int tipoDoEmissor) {
        switch (tipoDoEmissor) {
        case VISA:
            return new EmissorVisa();
        case MASTERCARD:
            return new EmissorMastercard();
        default:
            throw new IllegalArgumentException("Tipo de emissor não suportado");
        }
    }
}
