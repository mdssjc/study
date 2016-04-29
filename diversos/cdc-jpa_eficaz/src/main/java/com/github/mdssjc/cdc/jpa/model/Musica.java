package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@IdClass(MusicaId.class)
public class Musica {

  // @EmbeddedId
  // private MusicaId id;

  @Id
  @OneToOne
  @JoinColumn(name = "codigo_id")
  private CodigoUnico codigoUnico;

  @Id
  @OneToOne
  @JoinColumn(name = "pessoa_id")
  private Pessoa      autor;

  private int         duracaoSegundos;
  private String      nome;

  public Musica() {
  }

  public Musica(final CodigoUnico codigoUnico, final Pessoa autor) {
    this.codigoUnico = codigoUnico;
    this.autor = autor;
  }

  public CodigoUnico getCodigoUnico() {
    return this.codigoUnico;
  }

  public void setCodigoUnico(final CodigoUnico codigoUnico) {
    this.codigoUnico = codigoUnico;
  }

  public Pessoa getAutor() {
    return this.autor;
  }

  public void setAutor(final Pessoa autor) {
    this.autor = autor;
  }

  public int getDuracaoSegundos() {
    return this.duracaoSegundos;
  }

  public void setDuracaoSegundos(final int duracaoSegundos) {
    this.duracaoSegundos = duracaoSegundos;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }
}
