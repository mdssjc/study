package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.linkedlist.NodeBST;
import com.github.mdssjc.algorithms.datastructure.symbol_table.OrderedST;

/**
 * Implementação de Symbol Table com Binary Search Tree.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

  private NodeBST<Key, Value> root;

  @Override
  public void put(final Key key, final Value val) {
    // TODO
  }

  @Override
  public Value get(final Key key) {
    // TODO
    return null;
  }

  @Override
  public int size() {
    return size(this.root);
  }

  private int size(final NodeBST<Key, Value> x) {
    if (x == null) {
      return 0;
    } else {
      return x.n;
    }
  }

  @Override
  public Key min() {
    return null;
  }

  @Override
  public Key max() {
    return null;
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
    return 0;
  }

  @Override
  public Key select(final int k) {
    return null;
  }

  @Override
  public Iterable<Key> keys(final Key lo, final Key hi) {
    return null;
  }
}
