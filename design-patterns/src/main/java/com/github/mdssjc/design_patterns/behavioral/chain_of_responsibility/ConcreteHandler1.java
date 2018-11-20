package com.github.mdssjc.design_patterns.behavioral.chain_of_responsibility;

/**
 * Concrete Handler.
 *
 * @author Marcelo dos Santos
 */
public class ConcreteHandler1 extends Handler {

  @Override
  <T> String handleRequest(final Class<T> clazz) {
    if (clazz == String.class) {
      return "Concrete Handler 1";
    } else {
      return super.handleRequest(clazz);
    }
  }
}
