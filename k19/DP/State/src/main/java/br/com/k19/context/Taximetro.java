package br.com.k19.context;

import br.com.k19.state.Bandeira;
import br.com.k19.state.concrete.Bandeira1;
import br.com.k19.state.concrete.Bandeira2;

/**
 * Context Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Taximetro {

  private Bandeira bandeira;
  final Bandeira   bandeira1 = new Bandeira1();
  final Bandeira   bandeira2 = new Bandeira2();

  public Taximetro() {
    this.bandeira = this.bandeira1;
  }

  public void bandeira1() {
    this.bandeira = this.bandeira1;
  }

  public void bandeira2() {
    this.bandeira = this.bandeira2;
  }

  public double calculaValorDaCorrida(final double tempo, final double distancia) {
    return this.bandeira.calculaValorDaCorrida(tempo, distancia);
  }
}
