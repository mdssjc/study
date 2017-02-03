package com.github.mdssjc.dp.composite.base;

import com.github.mdssjc.dp.composite.Component;
import com.github.mdssjc.dp.composite.concrete.Composite;
import com.github.mdssjc.dp.composite.concrete.Leaf;

/**
 * Test drive do padrão de projeto Composite.
 * <p>
 * Design Pattern
 * Structural - Composite
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Component composite = new Composite();
    composite.add(new Leaf());
    composite.add(new Leaf());

    final Composite c1 = new Composite();
    c1.add(new Leaf());

    composite.add(c1);

    composite.operation();
  }
}
