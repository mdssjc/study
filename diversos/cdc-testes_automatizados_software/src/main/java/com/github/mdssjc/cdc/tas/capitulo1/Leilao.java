package com.github.mdssjc.cdc.tas.capitulo1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Leilao implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              id;
  private String            descricao;
  @OneToMany
  private List<Lance>       lances;
  private Calendar          data;
  private boolean           encerrado;

  public Leilao() {
  }

  public Leilao(final String descricao) {
    this.descricao = descricao;
    this.lances = new ArrayList<>();
  }

  public Leilao(final String descricao, final double valor,
      final Usuario usuario,
      final boolean encerrado) {
    this(descricao);
    this.encerrado = encerrado;
    this.lances.add(new Lance(usuario, valor));
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
