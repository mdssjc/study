package com.github.mdssjc.design_patterns.structural.composite;

/**
 * Leaf.
 *
 * @author Marcelo dos Santos
 *
 */
public class Leaf implements Component {

  @Override
  public String operation() {
    return "Leaf";
  }
}
