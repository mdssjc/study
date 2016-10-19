package com.github.mdssjc.dp.decorator.concrete;

import com.github.mdssjc.dp.decorator.Decorator;
import com.github.mdssjc.dp.decorator.component.Component;

/**
 * Classe ConcreteDecoratorA.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteDecoratorA extends Decorator {

  public ConcreteDecoratorA(final Component component) {
    super(component);
  }

  @Override
  public void operation(final String message) {
    getComponent().operation("[AAA]" + message + "[AAA]");
  }
}
