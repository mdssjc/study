package br.com.k19.builder.concrete;

import java.util.Calendar;

import br.com.k19.builder.BoletoBuilder;
import br.com.k19.product.Boleto;
import br.com.k19.product.concrete.BBBoleto;

/**
 * Concrete Builder Class
 *
 * @author mdssjc
 *
 */
public class BBBoletoBuilder implements BoletoBuilder {

    private String   sacado;
    private String   cedente;
    private double   valor;
    private Calendar vencimento;
    private int      nossoNumero;

    @Override
    public void buildSacado(final String sacado) {
        this.sacado = sacado;
    }

    @Override
    public void buildCedente(final String cedente) {
        this.cedente = cedente;
    }

    @Override
    public void buildValor(final double valor) {
        this.valor = valor;
    }

    @Override
    public void buildVencimento(final Calendar vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public void buildNossoNumero(final int nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    @Override
    public Boleto getBoleto() {
        return new BBBoleto(this.sacado, this.cedente, this.valor,
                this.vencimento, this.nossoNumero);
    }
}
