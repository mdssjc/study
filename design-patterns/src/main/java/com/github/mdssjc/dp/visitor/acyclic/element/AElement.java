package com.github.mdssjc.dp.visitor.acyclic.element;

import com.github.mdssjc.dp.visitor.acyclic.AVisitor;

/**
 * Interface AElement.
 *
 * @author Marcelo dos Santos
 *
 */
public interface AElement<T> {

  <T> T accept(AVisitor visitor);
}
