package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Concrete Visitor 1.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteVisitor1 implements Visitor {

  @Override
  public void visitConcreteElementA(final ConcreteElementA element) {
    System.out.println("Visitor 1: " + element.operationA());
  }

  @Override
  public void visitConcreteElementB(final ConcreteElementB element) {
    System.out.println("Visitor 1: " + element.operationB());
  }
}
