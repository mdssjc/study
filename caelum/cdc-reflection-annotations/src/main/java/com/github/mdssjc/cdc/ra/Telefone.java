package com.github.mdssjc.cdc.ra;

public class Telefone {

  private String codigoPais;
  private String operadora;

  public Telefone(String codigoPais, String operadora) {
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
