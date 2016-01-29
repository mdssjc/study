package br.com.k19.mediator.concrete;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.colleague.concrete.Passageiro;
import br.com.k19.colleague.concrete.Taxi;

/**
 * Concrete Mediator Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class CentralDeTaxi {

  private final List<Taxi>       taxisLivres         = new ArrayList<>();
  private final List<Passageiro> passageirosEmEspera = new ArrayList<>();

  public synchronized void adicionaTaxiDisponivel(final Taxi taxi) {
    System.out.println("Taxi " + taxi.getId() + " voltou para fila");
    this.taxisLivres.add(taxi);
    this.notifyAll();
  }

  public void pedeTaxi(final Passageiro passageiro) {
    final Taxi taxi = esperaTaxi(passageiro);
    System.out.println("Taxi " + taxi.getId() + " levando " + passageiro.getNome());
    taxi.atende();
  }

  private Taxi esperaTaxi(final Passageiro passageiro) {
    this.passageirosEmEspera.add(passageiro);
    synchronized (this) {
      while (this.taxisLivres.isEmpty() || !this.passageirosEmEspera.get(0).equals(passageiro)) {
        try {
          this.wait();
        } catch (final InterruptedException e) {
          e.printStackTrace();
        }
      }
      this.passageirosEmEspera.remove(0);
      return this.taxisLivres.remove(0);
    }
  }
}
