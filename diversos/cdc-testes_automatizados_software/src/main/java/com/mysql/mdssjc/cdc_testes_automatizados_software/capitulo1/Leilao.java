package com.mysql.mdssjc.cdc_testes_automatizados_software.capitulo1;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

  private String      descricao;
  private List<Lance> lances;

  public Leilao(String descricao) {
    this.descricao = descricao;
    lances = new ArrayList<>();
  }

  public void propoe(Lance lance) {
    lances.add(lance);
  }

  public List<Lance> getLances() {
    return lances;
  }
}
