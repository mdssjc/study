package com.github.mdssjc.algorithms.chapter1.exercises13;

/**
 * DoubleNode Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class DoubleNode<T> {

  private DoubleNode<T> prev;
  private DoubleNode<T> next;
  private T value;

  public DoubleNode prev() {
    return this.prev;
  }

  public DoubleNode next() {
    return this.next;
  }

  @Override
  public String toString() {
    return this.value.toString();
  }

  public static DoubleNode enqueue(final DoubleNode node, final Object value) {
    final DoubleNode root = new DoubleNode();
    root.value = value;

    if (node == null) {
      return root;
    }

    DoubleNode ref = node;
    while (ref.prev != null) {
      ref = ref.prev;
    }

    root.next = ref;
    ref.prev = root;
    return root;
  }

  public static DoubleNode dequeue(final DoubleNode node) {
    DoubleNode root = null;

    if (node != null) {
      root = node;
      while (root.prev != null) {
        root = root.prev;
      }
      root.next.prev = null;
    }

    return root;
  }

  public static DoubleNode push(final DoubleNode node, final Object value) {
    final DoubleNode root = new DoubleNode();
    root.value = value;

    if (node == null) {
      return root;
    }

    DoubleNode ref = node;
    while (ref.next != null) {
      ref = ref.next;
    }

    root.prev = ref;
    ref.next = root;
    return root;
  }

  public static DoubleNode pop(final DoubleNode node) {
    DoubleNode root = null;

    if (node != null) {
      root = node;
      while (root.next != null) {
        root = root.next;
      }
      root.prev.next = null;
    }

    return root;
  }

  public static void insertAfter(final DoubleNode node, final Object value) {
    if (node != null) {
      final DoubleNode ref = node.next;

      final DoubleNode root = new DoubleNode();
      root.next = ref;
      root.prev = node;
      root.value = value;

      if (ref != null) {
        ref.prev = root;
      }
      node.next = root;
    }
  }

  public static void insertBefore(final DoubleNode node, final Object value) {
    if (node != null) {
      final DoubleNode ref = node.prev;

      final DoubleNode root = new DoubleNode();
      root.next = node;
      root.prev = ref;
      root.value = value;

      if (ref != null) {
        ref.next = root;
      }
      node.prev = root;
    }
  }

  public static void remove(final DoubleNode node) {
    if (node != null) {
      final DoubleNode next = node.next;
      final DoubleNode prev = node.prev;

      if (next != null) {
        next.prev = prev;
      }
      if (prev != null) {
        prev.next = next;
      }
    }
  }
}
