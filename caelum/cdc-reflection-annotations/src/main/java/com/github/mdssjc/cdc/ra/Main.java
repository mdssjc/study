package com.github.mdssjc.cdc.ra;

public class Main {

  public static void main(final String[] args) {
    final Produto p = new Produto("Design Patterns", "Livro", 59.90,
        "Publicado pela Casa do Código");
    GeradorMapa.gerarMapa(p)
      .forEach((k, v) -> System.out.println(k + " = " + v));
  }
}
