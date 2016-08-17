package com.github.mdssjc.cdc.ra.ch01;

public class InvocadorNormal implements InvocadorMetodo {

  @Override
  public void invocarMetodo(final int vezes) {
    final ClasseTeste ct = new ClasseTeste();
    for (int i = 0; i < vezes; i++) {
      ct.metodoVazio();
    }
  }
}
