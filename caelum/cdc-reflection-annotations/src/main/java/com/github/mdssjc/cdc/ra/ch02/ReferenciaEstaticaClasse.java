package com.github.mdssjc.cdc.ra.ch02;

public class ReferenciaEstaticaClasse {

  public static void main(final String[] args) {
    final Class<String> classe = String.class;
    System.out.println(classe.getName());
    imprimeNomeClasse(Integer.class);
  }

  public static void imprimeNomeClasse(final Class<?> classe) {
    System.out.println("Chamado o método com " + classe.getName());
  }
}
