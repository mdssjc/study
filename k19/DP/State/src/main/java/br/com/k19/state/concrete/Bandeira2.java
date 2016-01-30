package br.com.k19.state.concrete;

import br.com.k19.state.Bandeira;

/**
 * Concrete State Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Bandeira2 implements Bandeira {

  @Override
  public double calculaValorDaCorrida(final double tempo, final double distancia) {
    return 10.0 + tempo * 3.0 + distancia * 4.0;
  }
}
