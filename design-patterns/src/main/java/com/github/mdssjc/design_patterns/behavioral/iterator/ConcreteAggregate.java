package com.github.mdssjc.design_patterns.behavioral.iterator;

/**
 * Concrete Aggregate.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteAggregate implements Aggregate {

  private final String[] messages = new String[]{"message 1", "message 2", "message 3"};

  @Override
  public Iterator createIterator() {
    return new ConcreteIterator(this);
  }

  public int size() {
    return this.messages.length;
  }

  public String get(final int index) {
    return this.messages[index];
  }
}
