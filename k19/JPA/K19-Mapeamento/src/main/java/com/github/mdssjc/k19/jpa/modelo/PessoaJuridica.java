package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class PessoaJuridica extends Pessoa {

  private String cnpj;
}
