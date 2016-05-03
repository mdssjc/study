package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {

  @Id
  @GeneratedValue
  private int    id;
  private String nomeRua;

  public Endereco() {
  }

  public int getId() {
    return this.id;
  }

  public String getNomeRua() {
    return this.nomeRua;
  }

  public void setNomeRua(String nomeRua) {
    this.nomeRua = nomeRua;
  }
}
