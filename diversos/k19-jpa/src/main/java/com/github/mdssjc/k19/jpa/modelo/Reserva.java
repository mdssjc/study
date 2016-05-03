package com.github.mdssjc.k19.jpa.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Reserva {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private LocalDate  inicio;
  private LocalDate  termino;
}
