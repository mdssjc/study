package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.symbol_table.OrderedST;

import java.util.Iterator;

/**
 * Implementação de Symbol Table com Busca Binária.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

  private final Key[] keys;
  private final Value[] values;
  private int n;

  public BinarySearchST(final int capacity) {
    this.keys = (Key[]) new Comparable[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  @Override
  public void put(final Key key, final Value value) {
    final int i = rank(key);
    if (i < this.n && this.keys[i].compareTo(key) == 0) {
      this.values[i] = value;
      return;
    }

    for (int j = this.n; j > i; j--) {
      this.keys[j] = this.keys[j - 1];
      this.values[j] = this.values[j - 1];
    }

    this.keys[i] = key;
    this.values[i] = value;
    this.n++;
  }

  @Override
  public Value get(final Key key) {
    if (isEmpty()) {
      return null;
    }

    final int i = rank(key);
    if (i < this.n && this.keys[i].compareTo(key) == 0) {
      return this.values[i];
    }
    return null;
  }

  @Override
  public int size() {
    return this.n;
  }

  @Override
  public Key min() {
    return this.keys[0];
  }

  @Override
  public Key max() {
    return this.keys[this.n - 1];
  }

  @Override
  public Key floor(final Key key) {
    return null;
  }

  @Override
  public Key ceiling(final Key key) {
    return null;
  }

  @Override
  public int rank(final Key key) {
    int lo = 0;
    int hi = this.n - 1;

    while (lo <= hi) {
      final int mid = lo + (hi - lo) / 2;
      final int cmp = key.compareTo(this.keys[mid]);
      if (cmp < 0) {
        hi = mid - 1;
      } else if (cmp > 0) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return lo;
  }

  @Override
  public Key select(final int k) {
    return null;
  }

  @Override
  public Iterable<Key> keys(final Key lo, final Key hi) {
    return null;
  }

  @Override
  public Iterator<Key> iterator() {
    return null;
  }
}
