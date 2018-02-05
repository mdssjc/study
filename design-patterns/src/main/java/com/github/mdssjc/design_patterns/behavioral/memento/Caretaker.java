package com.github.mdssjc.design_patterns.behavioral.memento;

import java.util.Stack;

/**
 * Caretaker.
 *
 * @author Marcelo dos Santos
 *
 */
public class Caretaker {

  private final Originator originator;
  private final Stack<Memento> mementos;

  public Caretaker(final Originator originator) {
    this.originator = originator;
    this.mementos = new Stack<>();
    this.mementos.push(originator.createMemento());
  }

  public void save() {
    this.mementos.push(this.originator.createMemento());
  }

  public void restore() {
    if (!this.mementos.isEmpty()) {
      this.originator.setMemento(this.mementos.pop());
    }
  }

  @Override
  public String toString() {
    return this.originator.toString();
  }
}
