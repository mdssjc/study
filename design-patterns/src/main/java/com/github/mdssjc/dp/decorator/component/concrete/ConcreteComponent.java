package com.github.mdssjc.dp.decorator.component.concrete;

import com.github.mdssjc.dp.decorator.component.Component;

/**
 * Classe ConcreteComponent.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteComponent implements Component {

  @Override
  public void operation(final String message) {
    System.out.println(message);
  }
}
