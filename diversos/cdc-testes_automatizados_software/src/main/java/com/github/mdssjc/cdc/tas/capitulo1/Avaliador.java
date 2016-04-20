package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Avaliador {

  private double      maiorDeTodos = Double.NEGATIVE_INFINITY;
  private double      menorDeTodos = Double.POSITIVE_INFINITY;
  private List<Lance> maiores;

  public void avalia(final Leilao leilao) {
    if (leilao.getLances().size()==0) {
      throw new RuntimeException("Não é possível avaliar um leilão sem lances");
    }

    for (final Lance lance : leilao.getLances()) {
      if (lance.getValor() > this.maiorDeTodos) {
        this.maiorDeTodos = lance.getValor();
      }
      if (lance.getValor() < this.menorDeTodos) {
        this.menorDeTodos = lance.getValor();
      }
    }

    pegaOsMaioresNo(leilao);
  }

  private void pegaOsMaioresNo(final Leilao leilao) {
    this.maiores = new ArrayList<>(leilao.getLances());
    Collections.sort(this.maiores, (o1, o2) -> {
      if (o1.getValor() < o2.getValor()) {
        return 1;
      }
      if (o1.getValor() > o2.getValor()) {
        return -1;
      }
      return 0;
    });
    this.maiores = this.maiores.subList(0,
        this.maiores.size() > 3 ? 3 : this.maiores.size());
  }

  public List<Lance> getTresMaiores() {
    return this.maiores;
  }

  public double getMaiorLance() {
    return this.maiorDeTodos;
  }

  public double getMenorLance() {
    return this.menorDeTodos;
  }
}
