package com.github.mdssjc.dp.facade.base;

import com.github.mdssjc.dp.facade.Facade;

/**
 * Test drive do padrão de projeto Facade.
 * <p>
 * Design Pattern
 * Structural - Facade
 *
 * Ao cliente: impõe a política de cima, visível e restringido
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Facade facade = new Facade();
    facade.message1();
    facade.message2();
    facade.message3();
  }
}
