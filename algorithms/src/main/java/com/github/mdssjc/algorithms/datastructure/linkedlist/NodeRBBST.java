package com.github.mdssjc.algorithms.datastructure.linkedlist;

import lombok.Data;

/**
 * Classe de composição da Red Black Binary Search Tree Symbol Table.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
@Data
public class NodeRBBST<Key, Value> {

  public static final boolean RED = true;
  public static final boolean BLACK = false;

  public Key key;
  public Value value;
  public NodeRBBST<Key, Value> left;
  public NodeRBBST<Key, Value> right;
  public int n;
  public boolean color;

  public NodeRBBST(final Key key, final Value val, final int n, final boolean color) {
    this.key = key;
    this.value = val;
    this.n = n;
    this.color = color;
  }

  public boolean isRed(final NodeRBBST x) {
    if (x == null) {
      return false;
    }
    return x.color == RED;
  }
}
