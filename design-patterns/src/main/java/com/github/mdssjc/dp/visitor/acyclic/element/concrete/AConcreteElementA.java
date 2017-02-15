package com.github.mdssjc.dp.visitor.acyclic.element.concrete;

import com.github.mdssjc.dp.visitor.acyclic.AVisitor;
import com.github.mdssjc.dp.visitor.acyclic.element.AElement;
import com.github.mdssjc.dp.visitor.acyclic.element.AVisitorA;

/**
 * Classe AConcreteElementA.
 *
 * @author Marcelo dos Santos
 *
 */
public class AConcreteElementA implements AElement<String> {

  public String operationA(final String sign) {
    return "Operation A: " + sign;
  }

  @Override
  public <T> T accept(final AVisitor visitor) {
    final AVisitorA avisitor = (AVisitorA) visitor;
    return (T) avisitor.visit(this);
  }
}
