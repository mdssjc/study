package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.queue.concrete.QueueLinkedList;
import com.github.mdssjc.algorithms.datastructure.symbol_table.OrderedST;
import lombok.Data;

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

  private Node<Key, Value> root;

  @Override
  public void put(final Key key, final Value value) {
    this.root = put(this.root, key, value);
  }

  private Node<Key, Value> put(final Node<Key, Value> x, final Key key, final Value value) {
    if (x == null) {
      return new Node<>(key, value, 1);
    }

    final int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = put(x.left, key, value);
    } else if (cmp > 0) {
      x.right = put(x.right, key, value);
    } else {
      x.value = value;
    }
    x.n = size(x.left) + size(x.right) + 1;
    return x;
  }

  @Override
  public Value get(final Key key) {
    return get(this.root, key);
  }

  private Value get(final Node<Key, Value> x, final Key key) {
    if (x == null) {
      return null;
    }

    final int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return get(x.left, key);
    } else if (cmp > 0) {
      return get(x.right, key);
    }
    return x.value;
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
  public Key min() {
    return min(this.root).key;
  }

  private Node<Key, Value> min(final Node<Key, Value> x) {
    if (x.left == null) {
      return null;
    }

    return min(x.left);
  }

  @Override
  public Key max() {
    return max(this.root).key;
  }

  private Node<Key, Value> max(final Node<Key, Value> x) {
    if (x.right == null) {
      return null;
    }

    return max(x.right);
  }

  @Override
  public Key floor(final Key key) {
    final Node<Key, Value> x = floor(this.root, key);
    if (x == null) {
      return null;
    }

    return x.key;
  }

  private Node<Key, Value> floor(final Node<Key, Value> x, final Key key) {
    if (x == null) {
      return null;
    }

    final int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp < 0) {
      return floor(x.left, key);
    }
    final Node<Key, Value> t = floor(x.right, key);
    if (t != null) {
      return t;
    } else {
      return x;
    }
  }

  @Override
  public Key ceiling(final Key key) {
    final Node<Key, Value> x = ceiling(this.root, key);
    if (x == null) {
      return null;
    }

    return x.key;
  }

  private Node<Key, Value> ceiling(final Node<Key, Value> x, final Key key) {
    if (x == null) {
      return null;
    }

    final int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp > 0) {
      return floor(x.right, key);
    }
    final Node<Key, Value> t = ceiling(x.left, key);
    if (t != null) {
      return t;
    } else {
      return x;
    }
  }

  @Override
  public int rank(final Key key) {
    return rank(key, this.root);
  }

  private int rank(final Key key, final Node<Key, Value> x) {
    if (x == null) {
      return 0;
    }

    final int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return rank(key, x.left);
    } else if (cmp > 0) {
      return 1 + size(x.left) + rank(key, x.right);
    } else {
      return size(x.left);
    }
  }

  @Override
  public Key select(final int k) {
    return select(this.root, k).key;
  }

  private Node<Key, Value> select(final Node<Key, Value> x, final int k) {
    if (x == null) {
      return null;
    }

    final int t = size(x.left);
    if (t > k) {
      return select(x.left, k);
    } else if (t < k) {
      return select(x.right, k - t - 1);
    } else {
      return x;
    }
  }

  @Override
  public void deleteMin() {
    this.root = deleteMin(this.root);
  }

  private Node<Key, Value> deleteMin(final Node<Key, Value> x) {
    if (x.left == null) {
      return x.right;
    }
    x.left = deleteMin(x.left);
    x.n = size(x.left) + size(x.right) + 1;
    return x;
  }

  @Override
  public void deleteMax() {
    this.root = deleteMax(this.root);
  }

  private Node<Key, Value> deleteMax(final Node<Key, Value> x) {
    if (x.right == null) {
      return x.left;
    }
    x.right = deleteMax(x.right);
    x.n = size(x.right) + size(x.left) + 1;
    return x;
  }

  @Override
  public void delete(final Key key) {
    this.root = delete(this.root, key);
  }

  private Node<Key, Value> delete(Node<Key, Value> x, final Key key) {
    if (x == null) {
      return null;
    }

    final int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = delete(x.left, key);
    } else if (cmp > 0) {
      x.right = delete(x.right, key);
    } else {
      if (x.right == null) {
        return x.left;
      }
      if (x.left == null) {
        return x.right;
      }
      final Node<Key, Value> t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.n = size(x.left) + size(x.right) + 1;
    return x;
  }

  @Override
  public Iterable<Key> keys(final Key lo, final Key hi) {
    final QueueLinkedList<Key> queue = new QueueLinkedList<>();
    keys(this.root, queue, lo, hi);
    return queue;
  }

  private void keys(final Node<Key, Value> x, final QueueLinkedList<Key> queue, final Key lo, final Key hi) {
    if (x == null) {
      return;
    }

    final int cmplo = lo.compareTo(x.key);
    final int cmphi = hi.compareTo(x.key);
    if (cmplo < 0) {
      keys(x.left, queue, lo, hi);
    }
    if (cmplo <= 0 && cmphi >= 0) {
      queue.enqueue(x.key);
    }
    if (cmphi > 0) {
      keys(x.right, queue, lo, hi);
    }
  }

  @Data
  public static class Node<Key, Value> {

    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public int n;

    public Node(final Key key, final Value val, final int n) {
      this.key = key;
      this.value = val;
      this.n = n;
    }
  }
}
