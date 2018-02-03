package com.github.mdssjc.design_patterns.behavioral.iterator;

/**
 * Iterator.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Iterator<T> {

  void first();

  void next();

  boolean isDone();

  T currentItem();
}
