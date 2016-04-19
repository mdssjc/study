package com.github.mdssjc.cdc_testes_automatizados_software.capitulo1;

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
