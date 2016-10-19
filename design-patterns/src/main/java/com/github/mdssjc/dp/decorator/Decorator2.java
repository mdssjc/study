package com.github.mdssjc.dp.decorator;

import com.github.mdssjc.dp.decorator.component.Component;

/**
 * Classe Decorator2.
 *
 * @author Marcelo dos Santos
 *
 */
public class Decorator2 extends Component {

  private final Component component;

  public Decorator2(final Component component) {
    this.component = component;
  }

  @Override
  public String text() {
    return "==" + this.component.text() + "==";
  }
}
