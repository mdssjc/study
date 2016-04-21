package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Leilao {

  private final String      descricao;
  private final List<Lance> lances;
  private Calendar          data;
  private boolean           encerrado;

  public Leilao(final String descricao) {
    this.descricao = descricao;
    this.lances = new ArrayList<>();
  }

  public void propoe(final Lance lance) {
    if (this.lances.isEmpty() || podeDarLance(lance.getUsuario())) {
      this.lances.add(lance);
    }
  }

  public String getDescricao() {
    return this.descricao;
  }

  public List<Lance> getLances() {
    return Collections.unmodifiableList(this.lances);
  }

  public Calendar getData() {
    return this.data;
  }

  public void setData(final Calendar data) {
    this.data = data;
  }

  public boolean isEncerrado() {
    return this.encerrado;
  }

  public void encerra() {
    this.encerrado = true;
  }

  private Lance ultimoLanceDado() {
    return this.lances.get(this.lances.size() - 1);
  }

  private boolean podeDarLance(final Usuario usuario) {
    return !ultimoLanceDado().getUsuario()
                             .equals(usuario)
        && qtdDeLancesDo(usuario) < 5;
  }

  private int qtdDeLancesDo(final Usuario usuario) {
    return (int) this.lances.stream()
                            .filter(l -> l.getUsuario() == usuario)
                            .count();
  }
}
