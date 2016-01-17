package br.com.k19.builder;

import java.util.Calendar;

import br.com.k19.product.Boleto;

/**
 * Builder Interface
 *
 * @author mdssjc
 *
 */
public interface BoletoBuilder {

    void buildSacado(String sacado);

    void buildCedente(String cedente);

    void buildValor(double valor);

    void buildVencimento(Calendar vencimento);

    void buildNossoNumero(int nossoNumero);

    Boleto getBoleto();
}
