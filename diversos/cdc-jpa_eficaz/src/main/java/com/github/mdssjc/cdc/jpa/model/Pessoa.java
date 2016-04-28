package com.github.mdssjc.cdc.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {

  @Id
  private int    id;
  private String nome;
}
