package com.github.mdssjc.design_patterns.behavioral.iterator;

/**
 * Padrão de projeto: Iterator.
 * <p>
 * Design Pattern
 * Object Behavioral / Extensions - Iterator (Cursor)
 * <p>
 * O padrão Iterator fornece meios de acessar, sequencialmente, os elementos de
 * um objeto agregado sem expor a sua representação subjacente.
 * <p>
 * External iterator (Active): o cliente controla a iteração.
 * Internal iterator (Passive): o iterator controla a iteração.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Aggregate aggregate = new ConcreteAggregate();
    final Iterator<String> iterator = aggregate.createIterator();

    for (iterator.first(); !iterator.isDone(); iterator.next()) {
      System.out.println(iterator.currentItem());
    }
  }
}
