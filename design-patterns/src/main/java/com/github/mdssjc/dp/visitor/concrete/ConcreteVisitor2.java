package com.github.mdssjc.dp.visitor.concrete;

import com.github.mdssjc.dp.visitor.Visitor;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementA;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementB;

/**
 * Classe ConcreteVisitor2.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteVisitor2 implements Visitor<Integer> {

  @Override
  public Integer visit(final ConcreteElementA element) {
    return element.operationA("A").length();
  }

  @Override
  public Integer visit(final ConcreteElementB element) {
    return element.operationB("AB").length();
  }
}
