package com.github.mdssjc.design_patterns.behavioral.chain_of_responsibility;

/**
 * Concrete Handler.
 *
 * @author Marcelo dos Santos
 */
public class ConcreteHandler2 extends Handler {

  @Override
  <T> String handleRequest(final Class<T> clazz) {
    if (clazz == Integer.class) {
      return String.valueOf(12345);
    } else {
      return super.handleRequest(clazz);
    }
  }
}
