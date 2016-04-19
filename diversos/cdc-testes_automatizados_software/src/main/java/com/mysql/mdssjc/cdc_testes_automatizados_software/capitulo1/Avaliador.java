package com.mysql.mdssjc.cdc_testes_automatizados_software.capitulo1;

public class Avaliador {

  private double maiorDeTodos = Double.NEGATIVE_INFINITY;
  private double menorDeTodos = Double.POSITIVE_INFINITY;

  public void avalia(final Leilao leilao) {
    for (final Lance lance : leilao.getLances()) {
      if (lance.getValor() > this.maiorDeTodos) {
        this.maiorDeTodos = lance.getValor();
      }
      if (lance.getValor() < this.menorDeTodos) {
        this.menorDeTodos = lance.getValor();
      }
    }
  }

  public double getMaiorLance() {
    return this.maiorDeTodos;
  }

  public double getMenorLance() {
    return this.menorDeTodos;
  }
}
