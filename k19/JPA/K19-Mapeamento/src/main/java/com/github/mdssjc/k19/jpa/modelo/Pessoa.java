package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private String     nome;
}
