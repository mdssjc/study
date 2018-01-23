package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Concrete Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteDecoratorA extends Decorator {

  public ConcreteDecoratorA(final Component component) {
    super(component);
  }

  @Override
  public String operation() {
    return super.operation() + " Concrete Decorator A";
  }
}
