package com.github.mdssjc.dp.visitor.acyclic.element;

import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementA;

/**
 * Interface AVisitorA.
 * <p>
 * Degenerate
 *
 * @author Marcelo dos Santos
 *
 */
public interface AVisitorA<T> {

  T visit(AConcreteElementA element);
}
