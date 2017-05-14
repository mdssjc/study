package com.github.mdssjc.algorithms.chapter3.section35;

public interface SET<Key> {

  void add(Key key);

  void delete(Key key);

  boolean contains(Key key);

  boolean isEmpty();

  int size();
}
