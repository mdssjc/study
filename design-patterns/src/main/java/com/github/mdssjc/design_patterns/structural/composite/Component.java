package com.github.mdssjc.design_patterns.structural.composite;

/**
 * Component.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Component {

  String operation();

  default void add(final Component component) {

  }

  default void remove(final Component component) {

  }

  default Component getChild(final int id) {
    throw new UnsupportedOperationException();
  }
}
