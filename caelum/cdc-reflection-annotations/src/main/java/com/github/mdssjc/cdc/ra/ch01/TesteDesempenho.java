package com.github.mdssjc.cdc.ra.ch01;

public class TesteDesempenho {

  public static void main(final String[] args) {
    final double normal = executaTeste(new InvocadorNormal());
    final double reflection = executaTeste(new InvocadorReflexao());
    System.out.println((reflection / normal) + " vezes mais que o normal");

    final double reflectionCache = executaTeste(new InvocadorReflexaoCache());
    System.out.println((reflectionCache / normal) + " vezes mais que o normal");
  }

  private static double executaTeste(final InvocadorMetodo invoc) {
    final long millis = System.nanoTime();
    invoc.invocarMetodo(100000);
    final String nomeClasse = invoc.getClass()
      .getName();
    final long diferenca = System.nanoTime() - millis;
    System.out.println(
        "A classe " + nomeClasse + " demorou " + diferenca + " nano segundos");
    return diferenca;
  }
}
