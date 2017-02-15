package com.github.mdssjc.dp.visitor.acyclic.concrete;

import com.github.mdssjc.dp.visitor.acyclic.AVisitor;
import com.github.mdssjc.dp.visitor.acyclic.element.AVisitorA;
import com.github.mdssjc.dp.visitor.acyclic.element.AVisitorB;
import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementA;
import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementB;

/**
 * Classe AConcreteVisitor2.
 *
 * @author Marcelo dos Santos
 *
 */
public class AConcreteVisitor2 implements AVisitor, AVisitorA<Integer>, AVisitorB<Integer> {

  @Override
  public Integer visit(final AConcreteElementA element) {
    return element.operationA("A")
                  .length();
  }

  @Override
  public Integer visit(final AConcreteElementB element) {
    return element.operationB("AB")
                  .length();
  }
}
