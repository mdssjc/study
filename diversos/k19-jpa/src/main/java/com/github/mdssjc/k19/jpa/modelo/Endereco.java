package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco {

  private String estado;
  private String cidade;
  private String logradouro;
  private int    numero;
}
