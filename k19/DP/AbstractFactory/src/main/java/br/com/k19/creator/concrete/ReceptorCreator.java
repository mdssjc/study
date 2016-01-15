package br.com.k19.creator.concrete;

import br.com.k19.creator.Creator;
import br.com.k19.product.Receptor;
import br.com.k19.product.concrete.ReceptorMastercard;
import br.com.k19.product.concrete.ReceptorVisa;

/**
 * Concrete Creator Class
 *
 * @author mdssjc
 *
 */
public class ReceptorCreator implements Creator<Receptor> {

    public Receptor create(int tipoDoReceptor) {
        switch (tipoDoReceptor) {
        case VISA:
            return new ReceptorVisa();
        case MASTERCARD:
            return new ReceptorMastercard();
        default:
            throw new IllegalArgumentException(
                    "Tipo de receptor não suportado.");
        }
    }
}
