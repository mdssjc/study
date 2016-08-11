package com.github.mdssjc.cdc.ra;

import java.lang.reflect.Method;

public class InvocadorReflexaoCache implements InvocadorMetodo {

  @Override
  public void invocarMetodo(final int vezes) {
    try {
      final ClasseTeste ct = new ClasseTeste();
      final Method m = ct.getClass()
        .getMethod("metodoVazio");
      for (int i = 0; i < vezes; i++) {
        m.invoke(ct);
      }
    } catch (final Exception e) {
      throw new RuntimeException("Não consegui invocar o método", e);
    }
  }
}
