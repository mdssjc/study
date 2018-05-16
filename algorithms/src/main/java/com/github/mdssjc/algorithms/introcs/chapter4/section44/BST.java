package com.github.mdssjc.algorithms.introcs.chapter4.section44;

/**
 * Program 4.4.4 Binary search tree.
 *
 * @param <Key>
 *     Key
 * @param <Value>
 *     Value
 *
 * @author Marcelo dos Santos
 *
 */
public class BST<Key extends Comparable<Key>, Value> {

  private Node root;

  public Value get(final Key key) {
    return get(this.root, key);
  }

  private Value get(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    final int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return get(x.left, key);
    } else if (cmp > 0) {
      return get(x.right, key);
    } else {
      return x.val;
    }
  }

  public void put(final Key key, final Value val) {
    this.root = put(this.root, key, val);
  }

  private Node put(final Node x, final Key key, final Value val) {
    if (x == null) {
      return new Node(key, val);
    }
    final int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = put(x.left, key, val);
    } else if (cmp > 0) {
      x.right = put(x.right, key, val);
    } else {
      x.val = val;
    }
    return x;
  }

  private class Node {

    Key key;
    Value val;
    Node left, right;

    Node(final Key key, final Value val) {
      this.key = key;
      this.val = val;
    }
  }
}
