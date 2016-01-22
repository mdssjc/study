package br.com.k19.adapter;

import br.com.k19.adaptee.ControleDePontoNovo;
import br.com.k19.adapter.target.ControleDePontoTarget;
import br.com.k19.model.Funcionario;

/**
 * Adapter Class
 *
 * @author mdssjc
 *
 */
public class ControleDePontoAdapter implements ControleDePontoTarget {

  private final ControleDePontoNovo controleDePontoNovo;

  public ControleDePontoAdapter() {
    this.controleDePontoNovo = new ControleDePontoNovo();
  }

  @Override
  public void registraEntrada(final Funcionario f) {
    this.controleDePontoNovo.registra(f, true);
  }

  @Override
  public void registraSaida(final Funcionario f) {
    this.controleDePontoNovo.registra(f, false);
  }
}
