package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;

/**
 * InfixToPostfix Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class InfixToPostfix {

  public static String convert(final String infix) {
    final Stack<String> ops = new StackLinkedList<>();
    final StringBuilder sb = new StringBuilder();

    for (final String s : infix.split(" ")) {
      if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
        ops.push(s);
      } else if (")".equals(s)) {
        sb.append(ops.pop() + ") ");
      } else {
        sb.append(s + " ");
      }
    }

    return sb.toString();
  }
}
