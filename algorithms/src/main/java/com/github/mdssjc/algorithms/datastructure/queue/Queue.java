package com.github.mdssjc.algorithms.datastructure.queue;

import java.util.Iterator;

/**
 * The {@code Queue} interface represents a first-in-first-out (FIFO)
 * queue of generic items.
 * <p>
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for testing if the queue is empty,
 * and iterating through the items in FIFO order.
 * <p>
 * For additional documentation, see
 * <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *     the generic type of an item in this queue
 */
public interface Queue<Item> extends Iterable<Item> {

  /**
   * Adds the item to this queue.
   *
   * @param item
   *     the item to add
   */
  void enqueue(Item item);

  /**
   * Removes and returns the item on this queue that was least recently added.
   *
   * @return the item on this queue that was least recently added
   */
  Item dequeue();

  /**
   * Returns true if this queue is empty.
   *
   * @return {@code true} if this queue is empty; {@code false} otherwise
   */
  boolean isEmpty();

  /**
   * Returns the number of items in this queue.
   *
   * @return the number of items in this queue
   */
  int size();

  /**
   * Returns an iterator that iterates over the items in this queue in FIFO
   * order.
   *
   * @return an iterator that iterates over the items in this queue in FIFO
   * order
   */
  @Override
  Iterator<Item> iterator();
}
