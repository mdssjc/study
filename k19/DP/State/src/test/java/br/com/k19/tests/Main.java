package br.com.k19.tests;

import br.com.k19.context.Taximetro;

/**
 * Design Pattern
 * Behavioral - State (Objects for States)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Taximetro taximetro = new Taximetro();

    taximetro.bandeira1();

    final double valor1 = taximetro.calculaValorDaCorrida(10, 20);
    System.out.println("Valor da corrida em bandeira 1: " + valor1);

    taximetro.bandeira2();

    final double valor2 = taximetro.calculaValorDaCorrida(10, 20);
    System.out.println("Valor da corrida em bandeira 2: " + valor2);
  }
}
