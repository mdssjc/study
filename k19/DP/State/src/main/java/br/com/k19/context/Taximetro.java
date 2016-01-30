package br.com.k19.context;

import br.com.k19.state.Bandeira;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Context Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class Taximetro {

  @Getter
  @Setter
  private Bandeira bandeira;

  public double calculaValorDaCorrida(final double tempo, final double distancia) {
    return this.bandeira.calculaValorDaCorrida(tempo, distancia);
  }
}
