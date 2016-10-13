package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;

/**
 * Classe Parentheses.
 *
 * @author Marcelo dos Santos
 *
 */
public class Parentheses {
  private final StackLinkedList<String> stack;
  private boolean result;

  public Parentheses() {
    stack = new StackLinkedList<>();
    result = true;
  }

  public void add(final String s) {
    if ("[".equals(s) ||
        "(".equals(s) ||
        "{".equals(s)) {
      stack.push(s);
    } else {
      final String element = stack.pop();
      if ("]".equals(s) && !"[".equals(element) ||
          ")".equals(s) && !"(".equals(element) ||
          "}".equals(s) && !"{".equals(element)) {
        result = false;
      }
    }
  }

  public boolean result() {
    return result;
  }
}
