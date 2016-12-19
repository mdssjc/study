package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.ArrayIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ResizingArrayDeque Class.
 * <p>
 * Double-Ended Queue
 *
 * @author Marcelo dos Santos
 *
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {

  private Item[] a;
  private int size;
  private int left;
  private int right;

  /**
   * Create an empty deque.
   */
  public ResizingArrayDeque() {
    this.a = (Item[]) new Object[1];
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

  private void resize(final int max) {
    final Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < this.size; i++) {
      temp[i] = this.a[(this.left + i) % this.a.length];
    }
    this.a = temp;
    this.left = 0;
    this.right = this.size;
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

    if (this.size == this.a.length) {
      resize(2 * this.a.length);
    }

    if (this.left == 0) {
      this.left = this.a.length - 1;
    } else {
      this.left--;
    }
    this.a[this.left] = item;

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

    if (this.size == this.a.length) {
      resize(2 * this.a.length);
    }

    if (this.right == this.a.length) {
      this.right = 0;
    }
    this.a[this.right++] = item;

    this.size++;
  }

  /**
   * Remove an item from the left end.
   *
   * @return the item removed
   */
  public Item popLeft() {
    checkEmpty();

    final Item item = this.a[this.left];
    this.a[this.left++] = null;
    this.size--;
    if (this.left == this.a.length) {
      this.left = 0;
    }

    if (this.size > 0 && this.size == this.a.length / 4) {
      resize(this.a.length / 2);
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

    final Item item = this.a[--this.right];
    this.a[this.right] = null;
    this.size--;
    if (this.right == 0) {
      this.right = this.a.length - 1;
    }

    if (this.size > 0 && this.size == this.a.length / 4) {
      resize(this.a.length / 2);
    }

    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    resize(this.size);
    return new ArrayIterator<>(this.a, this.size);
  }
}
