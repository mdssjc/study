package com.github.mdssjc.cdc.ra.ch02;

public class RecuperandoPeloObjeto {

  public static void main(final String[] args) {
    final Integer object = new Integer(100);
    final Class<? extends Number> c = object.getClass();
    System.out.println(c.getName());
    // ...
  }
}
