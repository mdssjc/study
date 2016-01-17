package br.com.k19.product.concrete;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.k19.product.Boleto;

/**
 * Concrete Product Class
 *
 * @author mdssjc
 *
 */
public class BBBoleto implements Boleto {

    private final String   sacado;
    private final String   cedente;
    private final double   valor;
    private final Calendar vencimento;
    private final int      nossoNumero;

    public BBBoleto(final String sacado, final String cedente,
            final double valor, final Calendar vencimento,
            final int nossoNumero) {
        this.sacado = sacado;
        this.cedente = cedente;
        this.valor = valor;
        this.vencimento = vencimento;
        this.nossoNumero = nossoNumero;
    }

    @Override
    public String getSacado() {
        return this.sacado;
    }

    @Override
    public String getCedente() {
        return this.cedente;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public Calendar getVencimento() {
        return this.vencimento;
    }

    @Override
    public int getNossoNumero() {
        return this.nossoNumero;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Boleto BB");
        stringBuilder.append("\n");

        stringBuilder.append("Sacado: " + this.sacado);
        stringBuilder.append("\n");

        stringBuilder.append("Cedente: " + this.cedente);
        stringBuilder.append("\n");

        stringBuilder.append("Valor: " + this.valor);
        stringBuilder.append("\n");

        stringBuilder.append("Vencimento: " + this.sacado);
        stringBuilder.append("\n");

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "dd/MM/yyyy");
        final String format = simpleDateFormat.format(
                this.vencimento.getTime());
        stringBuilder.append("Vencimento: " + format);
        stringBuilder.append("\n");

        stringBuilder.append("Nosso Número: " + this.nossoNumero);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
