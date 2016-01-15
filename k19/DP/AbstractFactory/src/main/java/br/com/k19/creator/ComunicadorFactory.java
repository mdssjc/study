package br.com.k19.creator;

import br.com.k19.product.Emissor;
import br.com.k19.product.Receptor;

/**
 * Creator Interface
 *
 * @author mdssjc
 *
 */
public interface ComunicadorFactory {

    Emissor createEmissor();

    Receptor createReceptor();
}
