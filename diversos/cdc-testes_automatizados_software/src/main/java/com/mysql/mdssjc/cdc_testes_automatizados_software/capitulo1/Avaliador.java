package com.mysql.mdssjc.cdc_testes_automatizados_software.capitulo1;

public class Avaliador {

  private double maiorDeTodos = Double.NEGATIVE_INFINITY;

  public void avalia(Leilao leilao) {
    for (Lance lance : leilao.getLances()) {
      if (lance.getValor() > maiorDeTodos) {
        maiorDeTodos = lance.getValor();
      }
    }
  }

  public double getMaiorLance() {
    return maiorDeTodos;
  }
}
