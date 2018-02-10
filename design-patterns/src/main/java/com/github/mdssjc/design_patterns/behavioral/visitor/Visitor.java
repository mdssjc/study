package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Visitor.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Visitor {

  void VisitConcreteElementA(ConcreteElementA element);

  void VisitConcreteElementB(ConcreteElementB element);
}
