package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Concrete Element A.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteElementA implements Element {

  @Override
  public void accept(final Visitor visitor) {
    visitor.visitConcreteElementA(this);
  }

  public String operationA() {
    return "Concrete Element A";
  }
}
