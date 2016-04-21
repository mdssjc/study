package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

  private final String      descricao;
  private final List<Lance> lances;

  public Leilao(final String descricao) {
    this.descricao = descricao;
    this.lances = new ArrayList<>();
  }

  public void propoe(final Lance lance) {
    if (this.lances.isEmpty() || !ultimoLanceDado().getUsuario()
                                                   .equals(
                                                       lance.getUsuario())) {
      this.lances.add(lance);
    }
  }

  public String getDescricao() {
    return this.descricao;
  }

  public List<Lance> getLances() {
    return Collections.unmodifiableList(this.lances);
  }

  private Lance ultimoLanceDado() {
    return lances.get(this.lances.size() - 1);
  }
}
