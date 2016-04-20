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

  @Override
  public boolean equals(final Object objeto) {
    if (this == objeto) {
      return true;
    }
    if (objeto == null) {
      return false;
    }
    if (getClass() != objeto.getClass()) {
      return false;
    }
    final Lance other = (Lance) objeto;
    if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(
        other.valor)) {
      return false;
    }
    return true;
  }
}
