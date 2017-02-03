package com.github.mdssjc.dp.composite.concrete;

import com.github.mdssjc.dp.composite.Component;

/**
 * Classe Leaf.
 *
 * @author Marcelo dos Santos
 *
 */
public class Leaf implements Component {

  @Override
  public void operation() {
    System.out.println("Leaf");
  }

  @Override
  public void add(final Component component) {
  }

  @Override
  public void remove(final Component component) {
  }

  @Override
  public Component getChild(final int id) {
    return null;
  }
}
