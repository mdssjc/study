package com.github.mdssjc.design_patterns.behavioral.iterator;

/**
 * Concrete Iterator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteIterator<T> implements Iterator<T> {

  private final ConcreteAggregate aggregate;
  private int current;

  public ConcreteIterator(final ConcreteAggregate aggregate) {
    this.aggregate = aggregate;
  }

  @Override
  public void first() {
    this.current = 0;
  }

  @Override
  public void next() {
    this.current++;
  }

  @Override
  public boolean isDone() {
    return this.current >= this.aggregate.size();
  }

  @Override
  public T currentItem() {
    if (isDone()) {
      throw new IndexOutOfBoundsException();
    }
    return (T) this.aggregate.get(this.current);
  }
}
