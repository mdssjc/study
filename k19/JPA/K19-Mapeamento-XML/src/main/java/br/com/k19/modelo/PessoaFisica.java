package br.com.k19.modelo;

import lombok.Getter;
import lombok.Setter;

public class PessoaFisica extends Pessoa {

  @Getter
  @Setter
  private String cpf;
}
