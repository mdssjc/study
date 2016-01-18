package br.com.k19.tests;

import br.com.k19.Configuracao;

/**
 * Design Pattern
 * Creational - Singleton
 *
 * @author mdssjc
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Configuracao configuracao = Configuracao.getInstance();
    System.out.println(configuracao.getPropriedade("time-zone"));
    System.out.println(configuracao.getPropriedade("currency-code"));
  }
}
