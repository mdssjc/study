package com.github.mdssjc.k19.jpa.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Usuario {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  @Column(unique = true)
  private String     email;
  @Temporal(TemporalType.DATE)
  private Calendar   dataDeCadastro;
  @Lob
  private byte[]     foto;
}
