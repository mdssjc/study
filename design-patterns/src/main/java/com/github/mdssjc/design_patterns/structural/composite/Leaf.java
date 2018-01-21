package com.github.mdssjc.design_patterns.structural.composite;

/**
 * Leaf.
 *
 * @author Marcelo dos Santos
 *
 */
public class Leaf implements Component {

  @Override
  public void operation() {
    System.out.println("Leaf");
  }
}
