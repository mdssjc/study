package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Concrete Decorator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteDecoratorB extends Decorator {

  private final String separator;

  public ConcreteDecoratorB(final Component component, final int spaces) {
    super(component);

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < spaces; i++) {
      sb.append(" ");
    }
    this.separator = sb.toString();
  }

  @Override
  public String operation() {
    return super.operation() + this.separator + "Concrete Decorator B";
  }
}
