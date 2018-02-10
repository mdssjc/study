package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Concrete Visitor 1.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteVisitor1 implements Visitor {

  @Override
  public void VisitConcreteElementA(final ConcreteElementA element) {
    System.out.println("Visitor 1: " + element.operationA());
  }

  @Override
  public void VisitConcreteElementB(final ConcreteElementB element) {
    System.out.println("Visitor 1: " + element.operationB());
  }
}
