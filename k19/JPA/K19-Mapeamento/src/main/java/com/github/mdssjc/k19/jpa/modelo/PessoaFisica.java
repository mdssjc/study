package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class PessoaFisica extends Pessoa {

  private String cpf;
}
