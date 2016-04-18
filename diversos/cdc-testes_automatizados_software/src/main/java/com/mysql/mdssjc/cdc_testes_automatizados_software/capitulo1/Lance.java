package com.mysql.mdssjc.cdc_testes_automatizados_software.capitulo1;

public class Lance {

  private Usuario usuario;
  private double  valor;

  public Lance(Usuario usuario, double valor) {
    this.usuario = usuario;
    this.valor = valor;
  }

  public double getValor() {
    return valor;
  }
}
