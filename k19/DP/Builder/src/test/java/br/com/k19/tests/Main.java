package br.com.k19.tests;

import br.com.k19.builder.BoletoBuilder;
import br.com.k19.builder.concrete.BBBoletoBuilder;
import br.com.k19.director.GeradorDeBoleto;
import br.com.k19.product.Boleto;

/**
 * Design Pattern
 * Creational - Builder
 *
 * @author mdssjc
 *
 */
public class Main {

    public static void main(String[] args) {
        BoletoBuilder boletoBuilder = new BBBoletoBuilder();
        GeradorDeBoleto geradorDeBoleto = new GeradorDeBoleto(boletoBuilder);
        Boleto boleto = geradorDeBoleto.geraBoleto();
        System.out.println(boleto);
    }
}
