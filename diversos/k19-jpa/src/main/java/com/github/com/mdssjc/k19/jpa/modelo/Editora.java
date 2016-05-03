package com.github.com.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Editora {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private String     nome;
  private String     email;
}
