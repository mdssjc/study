package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {

  private int m;
  private SequentialSearchST<Key, Value>[] st;

  public SeparateChainingHashST() {
    this(997);
  }

  public SeparateChainingHashST(int m) {
    this.m = m;
    st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
    for (int i = 0; i < m; i++) {
      st[i] = new SequentialSearchST();
    }
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  public Value get(Key key) {
    return st[hash(key)].get(key);
  }

  public void put(Key key, Value val) {
    st[hash(key)].put(key, val);
  }

  public Iterable<Key> keys() {
    return null;
  }
}
