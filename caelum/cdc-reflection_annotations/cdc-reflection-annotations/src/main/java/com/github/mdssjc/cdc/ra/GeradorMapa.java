package com.github.mdssjc.cdc.ra;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GeradorMapa {

  public static Map<String, Object> gerarMapa(final Object o) {
    final Class<?> classe = o.getClass();
    final Map<String, Object> mapa = new HashMap<>();
    for (final Method m : classe.getMethods()) {
      try {
        if (isGetter(m)) {
          final String propriedade = deGetterParaPropriedade(m.getName());
          final Object valor = m.invoke(o);
          mapa.put(propriedade, valor);
        }
      } catch (final Exception e) {
        throw new RuntimeException("Problema ao gerar o mapa", e);
      }
    }
    return mapa;
  }

  private static boolean isGetter(final Method m) {
    return m.getName()
      .startsWith("get") &&
        m.getReturnType() != void.class &&
        m.getParameterTypes().length == 0;
  }

  private static String deGetterParaPropriedade(final String nomeGetter) {
    final StringBuffer retorno = new StringBuffer();
    retorno.append(nomeGetter.substring(3, 4)
      .toLowerCase());
    retorno.append(nomeGetter.substring(4));
    return retorno.toString();
  }
}
