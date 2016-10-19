package com.github.mdssjc.dp.decorator.component;

/**
 * Classe ConcreteComponent.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteComponent extends Component {

  @Override
  public String text() {
    return String.valueOf(getResult());
  }
}
