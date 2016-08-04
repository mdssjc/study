package com.algaworks.wine.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vinho")
public class Vinho {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long       codigo;
  private String     nome;
  @Enumerated(EnumType.STRING)
  private TipoVinho  tipo;
  private Integer    safra;
  private Integer    volume;
  private BigDecimal valor;

  public Long getCodigo() {
    return this.codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public TipoVinho getTipo() {
    return this.tipo;
  }

  public void setTipo(TipoVinho tipo) {
    this.tipo = tipo;
  }

  public Integer getSafra() {
    return this.safra;
  }

  public void setSafra(Integer safra) {
    this.safra = safra;
  }

  public Integer getVolume() {
    return this.volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public BigDecimal getValor() {
    return this.valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
}
