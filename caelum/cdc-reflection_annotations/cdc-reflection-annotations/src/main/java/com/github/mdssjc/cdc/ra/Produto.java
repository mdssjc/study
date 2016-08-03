package com.github.mdssjc.cdc.ra;

public class Produto {

  private String nome;
  private String categoria;
  private Double preco;
  private String descricao;

  public Produto(final String nome, final String categoria, final Double preco,
      final String descricao) {
    this.nome = nome;
    this.categoria = categoria;
    this.preco = preco;
    this.descricao = descricao;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getCategoria() {
    return this.categoria;
  }

  public void setCategoria(final String categoria) {
    this.categoria = categoria;
  }

  public Double getPreco() {
    return this.preco;
  }

  public void setPreco(final Double preco) {
    this.preco = preco;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }
}
