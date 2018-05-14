package com.github.mdssjc.algorithms.introcs.chapter4.section44;

/**
 * Program 4.4.3 Hash table.
 *
 * @param <Key> Key
 * @param <Value> Value
 *
 * @author Marcelo dos Santos
 *
 */
public class HashST<Key, Value> {

  private final int m = 1024;
  private final Node[] lists = new Node[this.m];

  private int hash(final Key key) {
    return Math.abs(key.hashCode() % this.m);
  }

  public Value get(final Key key) {
    final int i = hash(key);
    for (Node x = this.lists[i]; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return (Value) x.val;
      }
    }
    return null;
  }

  public void put(final Key key, final Value val) {
    final int i = hash(key);
    for (Node x = this.lists[i]; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.val = val;
        return;
      }
    }
    this.lists[i] = new Node(key, val, this.lists[i]);
  }

  private static class Node {

    private final Object key;
    private Object val;
    private final Node next;

    public Node(final Object key, final Object val, final Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }
}
