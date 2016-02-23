package com.github.mdssjc.java_8_cdc;

public class Capitulo3 {

  public static void main(final String[] args) {
    // new Thread(() -> {
    // for (int i = 0; i < 1000; i++) {
    // System.out.println(i);
    // }
    // }).start();

    final Validador<String> validadorCEP = valor -> valor.matches(
        "[0-9]{5}-[0-9]{3}");

    System.out.println(validadorCEP.valida("12200-000"));
    System.out.println(validadorCEP.valida("122OO-000"));
  }
}
