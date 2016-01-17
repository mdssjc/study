package br.com.k19.product;

import java.util.Calendar;

/**
 * Product Interface
 *
 * @author mdssjc
 *
 */
public interface Boleto {

    String getSacado();

    String getCedente();

    double getValor();

    Calendar getVencimento();

    int getNossoNumero();

    String toString();
}
