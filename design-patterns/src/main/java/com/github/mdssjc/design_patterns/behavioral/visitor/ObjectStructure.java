package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Object Structure.
 *
 * @author Marcelo dos Santos
 *
 */
public class ObjectStructure {

  private final Element[] elements;

  public ObjectStructure(final Element... elements) {
    this.elements = elements;
  }

  public void execute(final Visitor visitor) {
    for (final Element element : this.elements) {
      element.accept(visitor);
    }
  }
}
