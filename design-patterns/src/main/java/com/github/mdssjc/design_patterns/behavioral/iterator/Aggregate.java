package com.github.mdssjc.design_patterns.behavioral.iterator;

/**
 * Aggregate.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Aggregate {

  Iterator createIterator();
}
