package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Concrete Component.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteComponent implements Component {

  @Override
  public String operation() {
    return "Concrete Component";
  }
}
