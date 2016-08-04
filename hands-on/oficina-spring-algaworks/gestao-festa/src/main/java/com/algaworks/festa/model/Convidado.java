package com.algaworks.festa.model;

public class Convidado {

  private String  nome;
  private Integer quantidadeAcompanhantes;

  public Convidado(final String nome, final Integer quantidadeAcompanhantes) {
    this.nome = nome;
    this.quantidadeAcompanhantes = quantidadeAcompanhantes;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public Integer getQuantidadeAcompanhantes() {
    return this.quantidadeAcompanhantes;
  }

  public void setQuantidadeAcompanhantes(
      final Integer quantidadeAcompanhantes) {
    this.quantidadeAcompanhantes = quantidadeAcompanhantes;
  }
}
