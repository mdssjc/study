package com.github.mdssjc.dp.visitor.concrete;

import com.github.mdssjc.dp.visitor.Visitor;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementA;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementB;

/**
 * Classe ConcreteVisitor1.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteVisitor1 implements Visitor<String> {

  @Override
  public String visit(final ConcreteElementA element) {
    return element.operationA("Visitado");
  }

  @Override
  public String visit(final ConcreteElementB element) {
    return element.operationB("Visitado");
  }
}
