package com.github.mdssjc.dp.visitor.acyclic.element.concrete;

import com.github.mdssjc.dp.visitor.acyclic.AVisitor;
import com.github.mdssjc.dp.visitor.acyclic.element.AElement;
import com.github.mdssjc.dp.visitor.acyclic.element.AVisitorB;

/**
 * Classe AConcreteElementB.
 *
 * @author Marcelo dos Santos
 *
 */
public class AConcreteElementB implements AElement<Integer> {

  public String operationB(final String sign) {
    return "Operation B: " + sign;
  }

  @Override
  public <T> T accept(final AVisitor visitor) {
    final AVisitorB avisitor = (AVisitorB) visitor;
    return (T) avisitor.visit(this);
  }
}
