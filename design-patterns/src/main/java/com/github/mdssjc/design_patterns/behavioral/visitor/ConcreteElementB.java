package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Concrete Element B.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteElementB implements Element {

  @Override
  public void accept(final Visitor visitor) {
    visitor.visitConcreteElementB(this);
  }

  public String operationB() {
    return "Concrete Element B";
  }
}
