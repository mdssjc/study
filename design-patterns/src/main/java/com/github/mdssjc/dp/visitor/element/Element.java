package com.github.mdssjc.dp.visitor.element;

import com.github.mdssjc.dp.visitor.Visitor;

/**
 * Interface Element.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Element {

  <T> T accept(Visitor<T> visitor);
}
