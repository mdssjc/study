package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

  @Id
  @GeneratedValue
  private int      id;
  private String   nome;
  private String   nomeArtistico;
  @OneToOne(cascade = CascadeType.PERSIST)
  private Endereco endereco;

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

  public Endereco getEndereco() {
    return this.endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
