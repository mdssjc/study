package br.com.k19.modelo;

import lombok.Getter;

public class FuncionarioDepartamento {

  @Getter
  private final String funcionario;
  @Getter
  private final String departamento;

  public FuncionarioDepartamento(final String funcionario,
      final String departamento) {
    this.funcionario = funcionario;
    this.departamento = departamento;
  }
}
