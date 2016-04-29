package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MusicaId.class)
public class Musica {

  @Id
  private int    duracaoSegundos;
  @Id
  private String nome;

  public Musica() {
  }

  public Musica(final int duracaoSegundos, final String nome) {
    this.duracaoSegundos = duracaoSegundos;
    this.nome = nome;
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
