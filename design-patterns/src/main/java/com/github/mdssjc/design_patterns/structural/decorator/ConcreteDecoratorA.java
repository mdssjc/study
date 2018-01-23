package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Concrete Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteDecoratorA extends Decorator {

  private final String separator;

  public ConcreteDecoratorA(final Component component, final String separator) {
    super(component);
    this.separator = separator;
  }

  @Override
  public String operation() {
    return super.operation() + this.separator + "Concrete Decorator A";
  }
}
