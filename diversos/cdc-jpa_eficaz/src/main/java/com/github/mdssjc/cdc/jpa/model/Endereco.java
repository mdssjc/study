package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

  @Id
  @GeneratedValue
  private int    id;
  private String nomeRua;
  @OneToOne(mappedBy = "endereco")
  private Pessoa pessoa;

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

  public Pessoa getPessoa() {
    return this.pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }
}
