package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Concrete Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteDecoratorB extends Decorator {

  public ConcreteDecoratorB(final Component component) {
    super(component);
  }

  @Override
  public String operation() {
    return super.operation() + " Concrete Decorator B";
  }
}
