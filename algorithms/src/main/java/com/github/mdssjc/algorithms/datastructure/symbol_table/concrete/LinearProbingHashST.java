package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.symbol_table.ST;

/**
 * Implementação de Symbol Table com Linear Probing Hash.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
public class LinearProbingHashST<Key, Value> implements ST<Key, Value> {

  private int n;
  private int m = 16;
  private Key[] keys;
  private Value[] values;

  public LinearProbingHashST() {
    this(16);
  }

  public LinearProbingHashST(final int capacity) {
    this.keys = (Key[]) new Object[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  private int hash(final Key key) {
    return (key.hashCode() & 0x7fffffff) % this.m;
  }

  private void resize(final int cap) {
    final LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
    for (int i = 0; i < this.m; i++) {
      if (this.keys[i] != null) {
        t.put(this.keys[i], this.values[i]);
      }
    }
    this.keys = t.keys;
    this.values = t.values;
    this.m = t.m;
  }

  @Override
  public void put(final Key key, final Value value) {
    if (this.n >= this.m / 2) {
      resize(2 * this.m);
    }
    int i;
    for (i = hash(key); this.keys[i] != null; i = (i + 1) % this.m) {
      if (this.keys[i].equals(key)) {
        this.values[i] = value;
        return;
      }
    }
    this.keys[i] = key;
    this.values[i] = value;
    this.n++;
  }

  @Override
  public Value get(final Key key) {
    for (int i = hash(key); this.keys[i] != null; i = (i + 1) % this.m) {
      if (this.keys[i].equals(key)) {
        return this.values[i];
      }
    }
    return null;
  }

  @Override
  public void delete(final Key key) {
    if (!contains(key)) {
      return;
    }
    int i = hash(key);
    while (!key.equals(this.keys[i])) {
      i = (i + 1) % this.m;
    }
    this.keys[i] = null;
    this.values[i] = null;
    i = (i + 1) % this.m;
    while (this.keys[i] != null) {
      final Key keyToRedo = this.keys[i];
      final Value valToRedo = this.values[i];
      this.keys[i] = null;
      this.values[i] = null;
      this.n--;
      put(keyToRedo, valToRedo);
      i = (i + 1) % this.m;
    }
    this.n--;
    if (this.n > 0 && this.n == this.m / 8) {
      resize(this.m / 2);
    }
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterable<Key> keys() {
    return null;
  }
}
