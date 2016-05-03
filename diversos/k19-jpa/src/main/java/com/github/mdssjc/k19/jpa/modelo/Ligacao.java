package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Ligacao {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  @ManyToOne
  private Fatura     fatura;
  private Integer    duracao;
}
