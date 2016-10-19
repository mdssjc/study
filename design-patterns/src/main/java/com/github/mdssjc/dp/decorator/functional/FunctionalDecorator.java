package com.github.mdssjc.dp.decorator.functional;

import java.util.function.UnaryOperator;

/**
 * Classe FunctionalDecorator.
 *
 * @author Marcelo dos Santos
 *
 */
public class FunctionalDecorator implements UnaryOperator<String> {

  @Override
  public String apply(final String s) {
    return s;
  }

  public static String tagA(final String s) {
    return "[AAA]" + s + "[AAA]";
  }

  public static String tagB(final String s) {
    return "[BBB]" + s + "[BBB]";
  }
}
