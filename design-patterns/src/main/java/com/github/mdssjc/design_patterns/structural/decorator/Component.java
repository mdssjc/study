package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Component.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Component {

  default String operation() {
    return "";
  }
}
