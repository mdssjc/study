package com.github.mdssjc.dp.visitor.element.concrete;

import com.github.mdssjc.dp.visitor.Visitor;
import com.github.mdssjc.dp.visitor.element.Element;

/**
 * Classe ConcreteElementA.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteElementA implements Element {

  public String operationA(final String sign) {
    return "Operation A: " + sign;
  }

  @Override
  public <T> T accept(final Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
