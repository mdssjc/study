package com.github.mdssjc.k19.jpa.modelo;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Candidato {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private String     nome;
  @Temporal(TemporalType.DATE)
  private Calendar   nascimento;
  @Embedded
  private Endereco   endereco;
}
