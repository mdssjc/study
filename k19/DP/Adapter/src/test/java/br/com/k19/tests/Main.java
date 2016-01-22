package br.com.k19.tests;

import br.com.k19.adapter.ControleDePontoAdapter;
import br.com.k19.adapter.target.ControleDePontoTarget;
import br.com.k19.model.Funcionario;

/**
 * Design Pattern
 * Structural - Adapter (Wrapper)
 *
 * @author mdssjc
 *
 */
public class Main {

  public static void main(final String[] args) throws InterruptedException {
    // ControleDePontoTarget controleDePonto = new ControleDePonto();
    final ControleDePontoTarget controleDePonto = new ControleDePontoAdapter();
    final Funcionario funcionario = new Funcionario("Marcelo Martins");
    controleDePonto.registraEntrada(funcionario);
    Thread.sleep(3000);
    controleDePonto.registraSaida(funcionario);
  }
}
