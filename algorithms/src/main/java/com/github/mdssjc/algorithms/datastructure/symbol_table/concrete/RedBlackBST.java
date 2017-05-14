package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.symbol_table.ST;
import lombok.Data;

/**
 * Implementação de Symbol Table com Red Black Binary Search Tree.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node<Key, Value> root;

  private boolean isRed(final Node<Key, Value> h) {
    if (h == null) {
      return false;
    }

    return h.color == RED;
  }

  private Node<Key, Value> rotateLeft(final Node<Key, Value> h) {
    final Node<Key, Value> x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.n = h.n;
    h.n = 1 + size(h.left) + size(h.right);
    return x;
  }

  private Node<Key, Value> rotateRight(final Node<Key, Value> h) {
    final Node<Key, Value> x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.n = h.n;
    h.n = 1 + size(h.left) + size(h.right);
    return x;
  }

  private void flipColors(final Node<Key, Value> h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  @Override
  public void put(final Key key, final Value value) {
    this.root = put(this.root, key, value);
    this.root.color = BLACK;
  }

  private Node<Key, Value> put(Node<Key, Value> h, final Key key, final Value value) {
    if (h == null) {
      return new Node<>(key, value, 1, RED);
    }

    final int cmp = key.compareTo(h.key);
    if (cmp < 0) {
      h.left = put(h.left, key, value);
    } else if (cmp > 0) {
      h.right = put(h.right, key, value);
    } else {
      h.value = value;
    }

    if (isRed(h.right) && !isRed(h.left)) {
      h = rotateLeft(h);
    }
    if (isRed(h.left) && isRed(h.left.left)) {
      h = rotateRight(h);
    }
    if (isRed(h.left) && isRed(h.right)) {
      flipColors(h);
    }

    h.n = size(h.left) + size(h.right) + 1;
    return h;
  }

  @Override
  public Value get(final Key key) {
    return null;
  }

  @Override
  public int size() {
    return size(this.root);
  }

  private int size(final Node<Key, Value> x) {
    if (x == null) {
      return 0;
    } else {
      return x.n;
    }
  }

  @Override
  public Iterable<Key> keys() {
    return null;
  }

  @Data
  public static class Node<Key, Value> {

    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public int n;
    public boolean color;

    public Node(final Key key, final Value val, final int n, final boolean color) {
      this.key = key;
      this.value = val;
      this.n = n;
      this.color = color;
    }
  }
}
