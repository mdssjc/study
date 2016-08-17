package com.github.mdssjc.cdc.ra.ch01;

import java.util.function.BiConsumer;

public class Main {

  public static void main(final String[] args) {
    final BiConsumer<String, Object> print = (k, v) -> System.out
      .println(k + " = " + v);

    final Produto p = new Produto("Design Patterns", "Livro", 59.90,
        "Publicado pela Casa do Código");
    GeradorMapa.gerarMapa(p)
      .forEach(print);

    final Telefone t = new Telefone("12", "TIM");
    GeradorMapa.gerarMapa(t)
      .forEach(print);

    GeradorMapaPerformance gerador;

    gerador = new GeradorMapaPerformance(Produto.class);
    gerador.gerarMapa(p)
      .forEach(print);

    gerador = new GeradorMapaPerformance(Telefone.class);
    gerador.gerarMapa(t)
      .forEach(print);
  }
}
