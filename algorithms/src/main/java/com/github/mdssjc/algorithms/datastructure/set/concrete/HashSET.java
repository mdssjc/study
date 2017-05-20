package com.github.mdssjc.algorithms.datastructure.set.concrete;

import com.github.mdssjc.algorithms.datastructure.set.SET;
import edu.princeton.cs.algs4.LinearProbingHashST;

public class HashSET<Key> implements SET<Key> {

  private final LinearProbingHashST<Key, Key> hashST;

  public HashSET() {
    hashST = new LinearProbingHashST<>();
  }

  @Override
  public void add(Key key) {
    hashST.put(key, key);
  }

  @Override
  public void delete(Key key) {
    hashST.delete(key);
  }

  @Override
  public boolean contains(Key key) {
    return hashST.contains(key);
  }

  @Override
  public boolean isEmpty() {
    return hashST.isEmpty();
  }

  @Override
  public int size() {
    return hashST.size();
  }
}
