package com.github.mdssjc.dp.interpreter.base;

import com.github.mdssjc.dp.interpreter.context.Interpreter;

/**
 * Test drive do padrão de projeto Interpreter.
 * <p>
 * Design Pattern
 * Behavioral - Interpreter
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Interpreter interpreter = new Interpreter();
    final int result = interpreter.evaluate("2 3 + 5 +");
    System.out.println(result);
  }
}
