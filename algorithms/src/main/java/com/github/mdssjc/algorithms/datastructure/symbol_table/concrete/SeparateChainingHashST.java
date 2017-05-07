package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.symbol_table.ST;
import edu.princeton.cs.algs4.SequentialSearchST;

/**
 * Implementação de Symbol Table com Separate Chaining Hash.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
public class SeparateChainingHashST<Key, Value> implements ST<Key, Value> {

  private final int m;
  private final SequentialSearchST<Key, Value>[] st;

  public SeparateChainingHashST() {
    this(997);
  }

  public SeparateChainingHashST(final int m) {
    this.m = m;
    this.st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
    for (int i = 0; i < m; i++) {
      this.st[i] = new SequentialSearchST();
    }
  }

  private int hash(final Key key) {
    return (key.hashCode() & 0x7fffffff) % this.m;
  }

  @Override
  public Value get(final Key key) {
    return this.st[hash(key)].get(key);
  }

  @Override
  public void put(final Key key, final Value value) {
    this.st[hash(key)].put(key, value);
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
