package br.com.k19.creator;

import br.com.k19.product.Emissor;

public interface Creator {

    Emissor create(int tipoDeEmissor);
}
