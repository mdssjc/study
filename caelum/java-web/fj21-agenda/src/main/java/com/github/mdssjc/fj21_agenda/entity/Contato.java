package com.github.mdssjc.fj21_agenda.entity;

import java.time.LocalDate;

public class Contato {

  private Long id;
  private String nome;
  private String email;
  private String endereco;
  private LocalDate dataNascimento;

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String novo) {
    this.nome = novo;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String novo) {
    this.email = novo;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(final String novo) {
    this.endereco = novo;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long novo) {
    this.id = novo;
  }

  public LocalDate getDataNascimento() {
    return this.dataNascimento;
  }

  public void setDataNascimento(final LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}
