package com.github.mdssjc.argentum.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

  private String nome;
  private final String mensagem = "Quem é você?";

  public OlaMundoBean() {
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getMensagem() {
    return this.mensagem;
  }

  public void nomeFoiDigitado() {
    System.out.println("\nChamou o botão");
  }
}
