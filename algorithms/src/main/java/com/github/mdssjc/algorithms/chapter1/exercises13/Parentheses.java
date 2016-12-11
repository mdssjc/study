package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.StackLinkedList;

/**
 * Parentheses Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Parentheses {

  private final Stack<String> stack;
  private boolean result;

  public Parentheses() {
    this.stack = new StackLinkedList<>();
    this.result = true;
  }

  public void add(final String s) {
    if ("[".equals(s) ||
        "(".equals(s) ||
        "{".equals(s)) {
      this.stack.push(s);
    } else {
      final String element = this.stack.pop();
      if ("]".equals(s) && !"[".equals(element) ||
          ")".equals(s) && !"(".equals(element) ||
          "}".equals(s) && !"{".equals(element)) {
        this.result = false;
      }
    }
  }

  public boolean result() {
    return this.result;
  }
}
