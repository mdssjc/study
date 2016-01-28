package br.com.k19.subject.real;

import br.com.k19.subject.Conta;

/**
 * Real Subject Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class ContaPadrao implements Conta {

  private double saldo;

  @Override
  public void deposita(final double valor) {
    this.saldo += valor;
  }

  @Override
  public void saca(final double valor) {
    this.saldo -= valor;
  }

  @Override
  public double getSaldo() {
    return this.saldo;
  }
}
