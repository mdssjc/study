package br.com.k19.colleague.concrete;

import br.com.k19.mediator.concrete.CentralDeTaxi;
import lombok.Getter;

/**
 * Concrete Colleague Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Taxi {

  private final CentralDeTaxi central;
  @Getter
  private final int           id;
  private static int          contador = 0;

  public Taxi(final CentralDeTaxi central) {
    this.central = central;
    this.id = Taxi.contador++;
  }

  public void atende() {
    try {
      Thread.sleep((long) (Math.random() * 3000.0));
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
    this.central.adicionaTaxiDisponivel(this);
  }
}
