package br.com.k19.director;

import java.util.Calendar;

import br.com.k19.builder.BoletoBuilder;
import br.com.k19.product.Boleto;

/**
 * Director Class
 *
 * @author mdssjc
 *
 */
public class GeradorDeBoleto {

    private final BoletoBuilder boletoBuilder;

    public GeradorDeBoleto(final BoletoBuilder boletoBuilder) {
        this.boletoBuilder = boletoBuilder;
    }

    public Boleto geraBoleto() {
        this.boletoBuilder.buildSacado("Marcelo Martins");
        this.boletoBuilder.buildCedente("K19 Treinamentos");
        this.boletoBuilder.buildValor(100.54);

        final Calendar vencimento = Calendar.getInstance();
        vencimento.add(Calendar.DATE, 30);
        this.boletoBuilder.buildVencimento(vencimento);

        this.boletoBuilder.buildNossoNumero(1234);

        final Boleto boleto = this.boletoBuilder.getBoleto();

        return boleto;
    }
}
