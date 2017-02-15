package com.github.mdssjc.dp.visitor.acyclic.element;

import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementB;

/**
 * Interface AVisitorB.
 * <p>
 * Degenerate
 *
 * @author Marcelo dos Santos
 *
 */
public interface AVisitorB<T> {

  T visit(AConcreteElementB element);
}
