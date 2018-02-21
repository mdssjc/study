package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Visitor.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Visitor {

  void visitConcreteElementA(ConcreteElementA element);

  void visitConcreteElementB(ConcreteElementB element);
}
