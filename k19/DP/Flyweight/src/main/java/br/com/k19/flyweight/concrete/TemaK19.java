package br.com.k19.flyweight.concrete;

import java.util.Arrays;

import br.com.k19.flyweight.TemaFlyweight;

/**
 * Concrete Flyweight Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class TemaK19 implements TemaFlyweight {

  @Override
  public void imprime(final String titulo, final String texto) {
    System.out.println("###" + titulo.toUpperCase() + "###");
    System.out.println(texto);
    final char[] rodapeE = new char[(int) (Math.floor(6 + titulo.length()) / 2.0)];
    final char[] rodapeD = new char[(int) (Math.ceil(6 + titulo.length()) / 2.0)];
    Arrays.fill(rodapeE, '#');
    Arrays.fill(rodapeD, '#');
    System.out.println(new String(rodapeE) + " www.k19.com.br " + new String(rodapeD));
  }
}
