package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Estado {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private String     nome;
  @OneToOne
  private Governador governador;
}
