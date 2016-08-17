package com.github.mdssjc.cdc.ra.ch01;

public class Telefone {

  private final String codigoPais;
  private final String operadora;

  public Telefone(final String codigoPais, final String operadora) {
    this.codigoPais = codigoPais;
    this.operadora = operadora;
  }

  @NomePropriedade("codigoInternacional")
  public String getCodigoPais() {
    return this.codigoPais;
  }

  @Ignorar
  public String getOperadora() {
    return this.operadora;
  }
}
