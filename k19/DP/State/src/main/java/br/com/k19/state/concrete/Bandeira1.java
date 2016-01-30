package br.com.k19.state.concrete;

import br.com.k19.state.Bandeira;

/**
 * Concrete State Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Bandeira1 implements Bandeira {

  @Override
  public double calculaValorDaCorrida(final double tempo, final double distancia) {
    return 5.0 + tempo * 1.5 + distancia * 1.7;
  }
}
