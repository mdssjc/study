package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.DoublyLinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.DoubleNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque Class.
 * <p>
 * Double-Ended Queue
 *
 * @author Marcelo dos Santos
 *
 */
public class Deque<Item> implements Iterable<Item> {

  private DoubleNode<Item> first;
  private DoubleNode<Item> last;
  private int size;

  /**
   * Create an empty deque.
   */
  public Deque() {
  }

  /**
   * Is the deque empty?
   *
   * @return {@code true} if this deque is empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Number of items in the deque.
   *
   * @return the number of items in this deque
   */
  public int size() {
    return this.size;
  }

  /**
   * Check null values.
   *
   * @param item
   *     the item to check
   */
  private void checkNull(final Item item) {
    if (item == null) {
      throw new NullPointerException("Null Pointer Exception");
    }
  }

  /**
   * Check empty.
   */
  private void checkEmpty() {
    if (isEmpty()) {
      throw new NoSuchElementException("No Such Element Exception");
    }
  }

  /**
   * Add an item to the left end.
   *
   * @param item
   *     the item to add
   */
  public void pushLeft(final Item item) {
    checkNull(item);

    final DoubleNode oldfirst = this.first;

    this.first = new DoubleNode();
    this.first.item = item;
    this.first.previous = null;
    this.first.next = oldfirst;

    if (isEmpty()) {
      this.last = this.first;
    } else {
      oldfirst.previous = this.first;
    }

    this.size++;
  }

  /**
   * Add an item to the right end.
   *
   * @param item
   *     the item to add
   */
  public void pushRight(final Item item) {
    checkNull(item);

    final DoubleNode oldlast = this.last;

    this.last = new DoubleNode();
    this.last.item = item;
    this.last.previous = oldlast;
    this.last.next = null;

    if (isEmpty()) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }

    this.size++;
  }

  /**
   * Remove an item from the left end.
   *
   * @return the item removed
   */
  public Item popLeft() {
    checkEmpty();

    final Item item = this.first.item;

    this.first = this.first.next;

    this.size--;
    if (isEmpty()) {
      this.last = this.first;
    } else {
      this.first.previous = null;
    }

    return item;
  }

  /**
   * Remove an item from the right end.
   *
   * @return the item removed
   */
  public Item popRight() {
    checkEmpty();

    final Item item = this.last.item;

    this.last = this.last.previous;

    this.size--;
    if (isEmpty()) {
      this.first = this.last;
    } else {
      this.last.next = null;
    }

    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new DoublyLinkedListIterator<>(this.first);
  }
}
