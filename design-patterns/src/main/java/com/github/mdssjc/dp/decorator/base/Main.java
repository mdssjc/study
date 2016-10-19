package com.github.mdssjc.dp.decorator.base;

import com.github.mdssjc.dp.decorator.Decorator;
import com.github.mdssjc.dp.decorator.Decorator2;
import com.github.mdssjc.dp.decorator.component.Component;
import com.github.mdssjc.dp.decorator.component.ConcreteComponent;

/**
 * Test drive do padrão de projeto Decorator.
 * <p>
 * Design Pattern
 * Structural - Decorator (Wrapper)
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    Component counter = new ConcreteComponent();

    System.out.println(counter.text());
    counter.inc();
    counter.inc();
    counter.inc();
    System.out.println(counter.text());

    counter = new Decorator(counter);
    counter.inc();
    System.out.println(counter.text());
    counter = new Decorator2(counter);
    System.out.println(counter.text());
  }
}
