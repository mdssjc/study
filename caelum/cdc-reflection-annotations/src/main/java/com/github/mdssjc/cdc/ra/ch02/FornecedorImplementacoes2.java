package com.github.mdssjc.cdc.ra.ch02;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplementacoes2 {

  private final Map<Class<?>, Class<?>> implementacoes = new HashMap<>();

  public FornecedorImplementacoes2(final String nomeArquivo) throws Exception {
    final Properties p = new Properties();
    p.load(new FileInputStream(nomeArquivo));

    for (final Object interf : p.keySet()) {
      final Class<?> interfType = Class.forName(interf.toString());
      final Class<?> implType = Class.forName(p.get(interf)
        .toString());

      if (!isAbstracaoEImplementacao(interfType, implType)) {
        throw new Exception("Erro na configuração do arquivo " + nomeArquivo
            + " : " + interfType.getName() + " não é abstração de "
            + implType.getName());
      }

      this.implementacoes.put(interfType, implType);
    }
  }

  public Class<?> getImplementacao(final Class<?> interf) {
    return this.implementacoes.get(interf);
  }

  public Object criarInstancia(final Class<?> interf, final Object... objs)
      throws Exception {
    final Class<?> impl = getImplementacao(interf);
    final Constructor<?> constr = acharConstrutor(impl, objs);
    return constr.newInstance(objs);
  }

  public static void main(final String[] args) {
    try {
      final FornecedorImplementacoes2 f = new FornecedorImplementacoes2(
          "implementacoes.prop");
      final Class<?> impl = f.getImplementacao(DAO.class);
      System.out.println("Implementação recuperada: " + impl.getName());
    } catch (final Exception e) {
      System.out
        .println("Problemas ao obter implementações: " + e.getMessage());
    }
  }

  private boolean isInterfaceOuAbstract(final Class<?> c) {
    return c.isInterface() || Modifier.isAbstract(c.getModifiers());
  }

  private boolean isAbstracaoEImplementacao(final Class<?> interf,
      final Class<?> impl) {
    return isInterfaceOuAbstract(interf) && !isInterfaceOuAbstract(impl)
        && interf.isAssignableFrom(impl);
  }

  private Constructor<?> acharConstrutor(final Class<?> c, final Object... objs)
      throws Exception {
    for (final Constructor<?> constr : c.getConstructors()) {
      final Class<?>[] params = constr.getParameterTypes();
      if (params.length == objs.length) {
        boolean erro = false;
        for (int i = 0; i < objs.length && !erro; i++) {
          if (!params[i].isInstance(objs[i])) {
            erro = true;
          }
          if (!erro) {
            return constr;
          }
        }
      }
    }
    throw new Exception("Construtor não encontradado");
  }
}
