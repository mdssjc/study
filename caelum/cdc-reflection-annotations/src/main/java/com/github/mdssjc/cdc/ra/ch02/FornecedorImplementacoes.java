package com.github.mdssjc.cdc.ra.ch02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplementacoes {

  private final Map<Class<?>, Class<?>> implementacoes = new HashMap<>();

  public FornecedorImplementacoes(final String nomeArquivo)
      throws IOException, ClassNotFoundException {
    final Properties p = new Properties();
    p.load(new FileInputStream(nomeArquivo));
    for (final Object interf : p.keySet()) {
      final Class<?> interfType = Class.forName(interf.toString());
      final Class<?> implType = Class.forName(p.get(interf)
        .toString());
      this.implementacoes.put(interfType, implType);
    }
  }

  public Class<?> getImplementacao(final Class<?> interf) {
    return this.implementacoes.get(interf);
  }

  public static void main(final String[] args) {
    try {
      final FornecedorImplementacoes f = new FornecedorImplementacoes(
          "implementacoes.prop");
      final Class<?> impl = f.getImplementacao(DAO.class);
      System.out.println("Implementação recuperada: " + impl.getName());
    } catch (ClassNotFoundException | IOException e) {
      System.out
        .println("Problemas ao obter implementações: " + e.getMessage());
    }
  }
}
