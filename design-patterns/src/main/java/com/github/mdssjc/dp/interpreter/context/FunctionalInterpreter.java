package com.github.mdssjc.dp.interpreter.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

/**
 * Classe FunctionalInterpreter.
 *
 * @author Marcelo dos Santos
 *
 */
public class FunctionalInterpreter {

  private final Map<String, IntBinaryOperator> opMap;

  public FunctionalInterpreter() {
    this.opMap = new HashMap<>();
    this.opMap.put("+", (a, b) -> a + b);
  }

  public int evaluate(final String expression) {
    final Stack<Integer> stack = new Stack<>();
    for (final String s : expression.split(" ")) {
      final IntBinaryOperator op = this.opMap.get(s);
      if (op != null) {
        final int right = stack.pop();
        final int left = stack.pop();
        stack.push(op.applyAsInt(left, right));
      } else {
        stack.push(Integer.parseInt(s));
      }
    }
    return stack.pop();
  }
}
