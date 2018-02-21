package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Concrete Visitor 2.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteVisitor2 implements Visitor {

  @Override
  public void visitConcreteElementA(final ConcreteElementA element) {
    System.out.println("Visitor 2: " + element.operationA());
  }

  @Override
  public void visitConcreteElementB(final ConcreteElementB element) {
    System.out.println("Visitor 2: " + element.operationB());
  }
}
