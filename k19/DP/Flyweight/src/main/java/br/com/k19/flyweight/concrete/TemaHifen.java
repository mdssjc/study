package br.com.k19.flyweight.concrete;

import java.util.Arrays;

import br.com.k19.flyweight.TemaFlyweight;

/**
 * Concrete Flyweight Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class TemaHifen implements TemaFlyweight {

  @Override
  public void imprime(final String titulo, final String texto) {
    System.out.println("---" + titulo + "---");
    System.out.println(texto);
    final char[] rodape = new char[22 + titulo.length()];
    Arrays.fill(rodape, '-');
    System.out.println(rodape);
  }
}
