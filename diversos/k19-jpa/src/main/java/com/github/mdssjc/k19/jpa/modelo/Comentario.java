package com.github.mdssjc.k19.jpa.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Comentario {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  @Temporal(TemporalType.DATE)
  private Calendar   data;
}
