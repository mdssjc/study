package com.github.mdssjc.dp.visitor.acyclic.concrete;

import com.github.mdssjc.dp.visitor.acyclic.AVisitor;
import com.github.mdssjc.dp.visitor.acyclic.element.AVisitorA;
import com.github.mdssjc.dp.visitor.acyclic.element.AVisitorB;
import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementA;
import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementB;

/**
 * Classe AConcreteVisitor1.
 *
 * @author Marcelo dos Santos
 *
 */
public class AConcreteVisitor1 implements AVisitor, AVisitorA<String>, AVisitorB<String> {

  @Override
  public String visit(final AConcreteElementA element) {
    return element.operationA("Visitado");
  }

  @Override
  public String visit(final AConcreteElementB element) {
    return element.operationB("Visitado");
  }
}
