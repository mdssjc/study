package com.github.mdssjc.cdc.ra;

import java.lang.reflect.Method;

public class InvocadorReflexao implements InvocadorMetodo {

  @Override
  public void invocarMetodo(final int vezes) {
    try {
      final ClasseTeste ct = new ClasseTeste();
      for (int i = 0; i < vezes; i++) {
        final Method m = ct.getClass()
          .getMethod("metodoVazio");
        m.invoke(ct);
      }
    } catch (final Exception e) {
      throw new RuntimeException("Não consegui invocar o método", e);
    }
  }
}
