package com.github.mdssjc.dp.visitor.element.concrete;

import com.github.mdssjc.dp.visitor.Visitor;
import com.github.mdssjc.dp.visitor.element.Element;

/**
 * Classe ConcreteElementB.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteElementB implements Element {

  public String operationB(final String sign) {
    return "Operation B: " + sign;
  }

  @Override
  public <T> T accept(final Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
