package br.com.k19.colleague.concrete;

import br.com.k19.mediator.concrete.CentralDeTaxi;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Concrete Colleague Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class Passageiro implements Runnable {

  @Getter
  private final String        nome;
  private final CentralDeTaxi central;

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      this.central.pedeTaxi(this);
    }
  }
}
