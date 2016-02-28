package com.github.mdssjc.java_8_cdc;

public class Usuario {

  private final String nome;
  private final int    pontos;
  private boolean      moderador;

  public Usuario(final String nome, final int pontos) {
    this.nome = nome;
    this.pontos = pontos;
    this.moderador = false;
  }

  public Usuario(final String string, final int pontos,
      final boolean moderador) {
    this(string, pontos);
    this.moderador = moderador;
  }

  public String getNome() {
    return this.nome;
  }

  public int getPontos() {
    return this.pontos;
  }

  public boolean isModerador() {
    return this.moderador;
  }

  public void tornaModerador() {
    this.moderador = true;
  }

  @Override
  public String toString() {
    return String.format("Usuário: %s(%d) - moderador[%s]", this.nome,
        this.pontos,
        this.moderador);
  }
}
