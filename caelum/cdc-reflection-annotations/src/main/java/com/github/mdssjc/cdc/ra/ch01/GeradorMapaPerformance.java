package com.github.mdssjc.cdc.ra.ch01;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GeradorMapaPerformance {

  private final Map<String, Method> propriedades = new HashMap<>();
  private final Class<?>            classe;

  public GeradorMapaPerformance(final Class<?> classe) {
    this.classe = classe;
    for (final Method m : classe.getMethods()) {
      if (isGetter(m)) {
        String propriedade = null;
        if (m.isAnnotationPresent(NomePropriedade.class)) {
          propriedade = m.getAnnotation(NomePropriedade.class)
            .value();
        } else {
          propriedade = deGetterParaPropriedade(m.getName());
        }
        this.propriedades.put(propriedade, m);
      }
    }
  }

  public Map<String, Object> gerarMapa(final Object o) {
    if (!this.classe.isInstance(o)) {
      throw new RuntimeException(
          "O objeto não é da classe " + this.classe.getName());
    }

    final Map<String, Object> mapa = new HashMap<>();
    for (final String propriedade : this.propriedades.keySet()) {
      try {
        final Method m = this.propriedades.get(propriedade);
        final Object valor = m.invoke(o);
        mapa.put(propriedade, valor);
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
        m.getParameterTypes().length == 0 &&
        !m.isAnnotationPresent(Ignorar.class);
  }

  private static String deGetterParaPropriedade(final String nomeGetter) {
    final StringBuffer retorno = new StringBuffer();
    retorno.append(nomeGetter.substring(3, 4)
      .toLowerCase());
    retorno.append(nomeGetter.substring(4));
    return retorno.toString();
  }
}
