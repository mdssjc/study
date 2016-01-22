package br.com.k19.modelo;

import lombok.Getter;
import lombok.Setter;

public class PessoaJuridica extends Pessoa {

  @Getter
  @Setter
  private String cnpj;
}
