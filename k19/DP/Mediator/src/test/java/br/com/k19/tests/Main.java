package br.com.k19.tests;

import br.com.k19.colleague.concrete.Passageiro;
import br.com.k19.colleague.concrete.Taxi;
import br.com.k19.mediator.concrete.CentralDeTaxi;

/**
 * Design Pattern
 * Behavioral - Mediator
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final CentralDeTaxi central = new CentralDeTaxi();

    final Passageiro p1 = new Passageiro("Rafael Cosentino", central);
    final Passageiro p2 = new Passageiro("Marcelo Martins", central);
    final Passageiro p3 = new Passageiro("Jonas Hirata", central);

    final Taxi t1 = new Taxi(central);
    central.adicionaTaxiDisponivel(t1);

    final Taxi t2 = new Taxi(central);
    central.adicionaTaxiDisponivel(t2);

    new Thread(p1).start();
    new Thread(p2).start();
    new Thread(p3).start();
  }
}
