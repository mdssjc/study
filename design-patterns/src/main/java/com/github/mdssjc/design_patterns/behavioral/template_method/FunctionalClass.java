package com.github.mdssjc.design_patterns.behavioral.template_method;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Functional Class.
 *
 * @author Marcelo dos Santos
 */
public class FunctionalClass {

  public final void templateMethod(final Supplier<String> primitiveOperation1,
                                   final Supplier<String> primitiveOperation2) {

    System.out.println(primitiveOperation1.get() +
                       " " +
                       Optional.ofNullable(primitiveOperation2.get())
                               .orElse(""));
  }
}
