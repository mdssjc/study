package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Governador {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private String     nome;
}
