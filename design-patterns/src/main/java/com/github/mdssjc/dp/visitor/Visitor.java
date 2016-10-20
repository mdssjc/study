package com.github.mdssjc.dp.visitor;

import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementA;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementB;

/**
 * Interface Visitor.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Visitor<T> {

  T visit(ConcreteElementA element);

  T visit(ConcreteElementB element);
}

