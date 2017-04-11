package com.github.mdssjc.dp.monostate.base;

import com.github.mdssjc.dp.monostate.Monostate;

/**
 * Test drive do padrão de projeto Monostate.
 * <p>
 * Design Pattern
 * <p>
 * Benefícios:
 *  - transparency;
 *  - derivability;
 *  - polymorphism; and
 *  - well-defined creation and destruction.
 * Custos:
 *  - no conversion;
 *  - efficiency;
 *  - presence; and
 *  - platform local.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Monostate m1 = new Monostate();
    final Monostate m2 = new Monostate();

    m1.setX(10);

    System.out.printf("m1: %d == m2: %d%n", m1.getX(), m2.getX());
  }
}
