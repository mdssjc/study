package br.com.k19.abstractclass;

import lombok.Getter;

/**
 * Abstract Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public abstract class Conta {

  @Getter
  private double saldo;

  public void deposita(final double valor) {
    this.saldo += valor;
    this.saldo -= calculaTaxa();
  }

  public void saca(final double valor) {
    this.saldo -= valor;
    this.saldo -= calculaTaxa();
  }

  public abstract double calculaTaxa();
}
