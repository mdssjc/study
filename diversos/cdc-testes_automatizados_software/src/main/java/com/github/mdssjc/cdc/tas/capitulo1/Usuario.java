package com.github.mdssjc.cdc.tas.capitulo1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

  @Id
  @GeneratedValue
  private int    id;
  private String nome;
  private String email;

  protected Usuario() {
  }

  public Usuario(final String nome, final String email) {
    this.nome = nome;
    this.email = email;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }
}
