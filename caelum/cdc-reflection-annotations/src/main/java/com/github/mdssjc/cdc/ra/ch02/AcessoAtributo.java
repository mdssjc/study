package com.github.mdssjc.cdc.ra.ch02;

import java.lang.reflect.Field;

public class AcessoAtributo extends SuperClasseAtributo {

  private int    atributoUm;
  public String atributoDois;

  public static void main(String[] args) {
    System.out.println("Retornado pelo getFields()");
    for (Field f : AcessoAtributo.class.getFields()) {
      System.out.println("- " + f.getType()
        .getSimpleName() + " " + f.getName());
    }
    System.out.println("Retornado pelo getDeclaredFields()");
    for (Field f : AcessoAtributo.class.getDeclaredFields()) {
      System.out.println("- " + f.getType()
        .getSimpleName() + " " + f.getName());
    }
  }
}
