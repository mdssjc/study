package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Leilao {

  @Id
  @GeneratedValue
  private int               id;
  private String            descricao;
  private Double            valorInicial;
  @ManyToOne
  private Usuario           dono;
  private Calendar          dataAbertura;
  private boolean           usado;
  private boolean           encerrado;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "leilao")
  private final List<Lance> lances;

  public Leilao() {
    this.lances = new ArrayList<>();
    this.dataAbertura = Calendar.getInstance();
  }

  public Leilao(final String descricao, final Double valorInicial,
      final Usuario dono, final boolean usado) {
    this();
    this.descricao = descricao;
    this.valorInicial = valorInicial;
    this.dono = dono;
    this.usado = usado;
  }

  public void setDataAbertura(final Calendar dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public Calendar getDataAbertura() {
    return this.dataAbertura;
  }

  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setValorInicial(final Double valorInicial) {
    this.valorInicial = valorInicial;
  }

  public Double getValorInicial() {
    return this.valorInicial;
  }

  public void setDono(final Usuario usuario) {
    this.dono = usuario;
  }

  public Usuario getDono() {
    return this.dono;
  }

  public boolean isUsado() {
    return this.usado;
  }

  public void setUsado(final boolean usado) {
    this.usado = usado;
  }

  public List<Lance> getLances() {
    return this.lances;
  }

  public int getId() {
    return this.id;
  }

  public void encerra() {
    this.encerrado = true;
  }

  public boolean isEncerrado() {
    return this.encerrado;
  }

  public void propoe(final Lance lance) {
    if (this.lances.isEmpty() || podeDarLance(lance.getUsuario())) {
      this.lances.add(lance);
    }
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
