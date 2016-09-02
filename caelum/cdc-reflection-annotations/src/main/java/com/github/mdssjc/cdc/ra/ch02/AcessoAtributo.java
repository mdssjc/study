package com.github.mdssjc.cdc.ra.ch02;

import java.lang.reflect.Field;

public class AcessoAtributo extends SuperClasseAtributo {

  private int   atributoUm;
  public String atributoDois;

  public static void main(String[] args) {
    printFields("Retornado pelo getFields()",
        AcessoAtributo.class.getFields());
    printFields("Retornado pelo getDeclaredFields()",
        AcessoAtributo.class.getDeclaredFields());
  }

  private static void printFields(String mensagem, Field[] fs) {
    System.out.println(mensagem);
    for (Field f : fs) {
      System.out.println("- " + f.getType()
        .getSimpleName() + " " + f.getName());
    }
  }
}
