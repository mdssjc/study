package com.github.mdssjc.design_patterns.behavioral.chain_of_responsibility;

import java.util.LinkedList;
import java.util.List;

/**
 * Handler.
 *
 * @author Marcelo dos Santos
 */
public class Handler {

  private final List<Handler> sucessor;
  private int index;

  public Handler() {
    this.sucessor = new LinkedList<>();
  }

  public void add(final Handler handler) {
    this.sucessor.add(handler);
  }

  <T> String handleRequest(final Class<T> clazz) {
    if (this.sucessor.isEmpty() || this.index >= this.sucessor.size()) {
      return "";
    } else {
      return this.sucessor.get(this.index++)
                          .handleRequest(clazz);
    }
  }
}
