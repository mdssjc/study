package com.github.mdssjc.algorithms.chapter1.exercises13;

import java.util.Iterator;

/**
 * Deque Interface.
 * <p>
 * Double-Ended Queue
 *
 * @author Marcelo dos Santos
 *
 */
public interface Deque<Item> extends Iterable<Item> {

  /**
   * Is the deque empty?
   *
   * @return {@code true} if this deque is empty; {@code false} otherwise
   */
  boolean isEmpty();

  /**
   * Number of items in the deque.
   *
   * @return the number of items in this deque
   */
  int size();

  /**
   * Add an item to the left end.
   *
   * @param item
   *     the item to add
   */
  void pushLeft(Item item);

  /**
   * Add an item to the right end.
   *
   * @param item
   *     the item to add
   */
  void pushRight(Item item);

  /**
   * Remove an item from the left end.
   *
   * @return the item removed
   */
  Item popLeft();

  /**
   * Remove an item from the right end.
   *
   * @return the item removed
   */
  Item popRight();

  @Override
  Iterator<Item> iterator();
}
