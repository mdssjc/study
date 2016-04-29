package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {

  @Id
  @GeneratedValue
  private int    id;
  private String nome;
  private String nomeArtistico;

  public Pessoa() {
  }

  public int getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getNomeArtistico() {
    return this.nomeArtistico;
  }

  public void setNomeArtistico(final String nomeArtistico) {
    this.nomeArtistico = nomeArtistico;
  }
}
