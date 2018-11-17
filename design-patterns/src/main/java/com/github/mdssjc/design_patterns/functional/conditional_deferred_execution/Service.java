package com.github.mdssjc.design_patterns.functional.conditional_deferred_execution;

import java.util.function.Supplier;

/**
 * Service.
 *
 * @author Marcelo dos Santos
 */
public class Service {

  public void print(final boolean question, final Supplier<String> message) {
    if (question) {
      System.out.println(message.get());
    }
  }
}
