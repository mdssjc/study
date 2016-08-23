package com.github.mdssjc.cdc.ra.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InformacaoClasse {

  public static void main(final String[] args) {
    System.out.println("Entre com o nome da classe que deseja informação:");
    final Scanner in = new Scanner(System.in);
    final String nomeClasse = in.nextLine();
    try {
      final Class<?> c = Class.forName(nomeClasse);
      imprimirHierarquia(c, 1);
    } catch (final ClassNotFoundException e) {
      System.out.println("A classe " + nomeClasse + " não foi encontrada");
    }
    in.close();
  }

  private static void imprimirHierarquia(final Class<?> c, final int nivel) {
    final List<Class<?>> lista = getSuperClasseEInterfaces(c);
    String recuo = "";
    for (int i = 0; i < nivel; i++) {
      recuo += "  ";
    }
    for (final Class<?> clazz : lista) {
      System.out.println(recuo + "|-> " + clazz.getName());
      if (clazz != Object.class) {
        imprimirHierarquia(clazz, nivel + 1);
      }
    }
  }

  private static List<Class<?>> getSuperClasseEInterfaces(final Class<?> c) {
    final List<Class<?>> lista = new ArrayList<>();
    if (c.getSuperclass() != null) {
      lista.add(c.getSuperclass());
    }
    lista.addAll(Arrays.asList(c.getInterfaces()));
    return lista;
  }
}
