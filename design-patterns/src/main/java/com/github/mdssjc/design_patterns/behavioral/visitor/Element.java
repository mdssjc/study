package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Element.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Element {

  void accept(Visitor visitor);
}
