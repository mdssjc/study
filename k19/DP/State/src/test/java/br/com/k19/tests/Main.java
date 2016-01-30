package br.com.k19.tests;

import br.com.k19.context.Taximetro;
import br.com.k19.state.Bandeira;
import br.com.k19.state.concrete.Bandeira1;
import br.com.k19.state.concrete.Bandeira2;

/**
 * Design Pattern
 * Behavioral - State (Objects for States)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Bandeira b1 = new Bandeira1();
    final Bandeira b2 = new Bandeira2();

    final Taximetro taximetro = new Taximetro(b1);

    final double valor1 = taximetro.calculaValorDaCorrida(10, 20);
    System.out.println("Valor da corrida em bandeira 1: " + valor1);

    taximetro.setBandeira(b2);

    final double valor2 = taximetro.calculaValorDaCorrida(10, 20);
    System.out.println("Valor da corrida em bandeira 1: " + valor2);
  }
}
