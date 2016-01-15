package br.com.k19.creator.concrete;

import br.com.k19.creator.Creator;
import br.com.k19.product.Emissor;
import br.com.k19.product.concrete.EmissorEmail;
import br.com.k19.product.concrete.EmissorJMS;
import br.com.k19.product.concrete.EmissorSMS;

/**
 * Concrete Creator Class
 *
 * @author mdssjc
 *
 */
public class EmissorCreator implements Creator {

    public static final int SMS   = 0;
    public static final int EMAIL = 1;
    public static final int JMS   = 2;

    @Override
    public Emissor create(int tipoDeEmissor) {
        switch (tipoDeEmissor) {
        case SMS:
            return new EmissorSMS();
        case EMAIL:
            return new EmissorEmail();
        case JMS:
            return new EmissorJMS();
        default:
            throw new IllegalArgumentException(
                    "Tipo de emissor não suportado.");
        }
    }
}
