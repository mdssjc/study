package com.github.mdssjc.algorithms.datastructure.linkedlist;

import lombok.Data;

/**
 * Classe de composição da Binary Search Tree Symbol Table.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
@Data
public class NodeBST<Key, Value> {

  public Key key;
  public Value value;
  public NodeBST<Key, Value> left;
  public NodeBST<Key, Value> right;
  public int n;

  public NodeBST(final Key key, final Value val, final int n) {
    this.key = key;
    this.value = val;
    this.n = n;
  }
}
