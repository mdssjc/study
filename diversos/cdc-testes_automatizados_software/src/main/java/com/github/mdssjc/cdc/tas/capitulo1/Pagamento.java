package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.Calendar;

public class Pagamento {

  private final double   valor;
  private final Calendar data;

  public Pagamento(final double valor, final Calendar data) {
    this.valor = valor;
    this.data = data;
  }

  public double getValor() {
    return this.valor;
  }

  public Calendar getData() {
    return this.data;
  }
}
