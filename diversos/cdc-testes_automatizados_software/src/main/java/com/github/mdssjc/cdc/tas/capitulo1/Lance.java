package com.github.mdssjc.cdc.tas.capitulo1;

public class Lance {

  private final Usuario usuario;
  private final double  valor;

  public Lance(final Usuario usuario, final double valor) {
    this.usuario = usuario;
    this.valor = valor;
  }

  public double getValor() {
    return this.valor;
  }
}
