package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
public class Conta {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private double     saldo;
  @Version
  private Long       versao;
}
