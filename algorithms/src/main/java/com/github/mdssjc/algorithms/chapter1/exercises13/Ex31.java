package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 31.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex31 {

  public static void main(final String[] args) {
    Executor.execute(Ex31.class, args);

    final DoubleNode root = DoubleNode.enqueue(null, "root");

    final DoubleNode nodeA = DoubleNode.enqueue(root, "nodeA");
    DoubleNode.push(root, "1");
    final DoubleNode node2 = DoubleNode.push(root, "2");
    DoubleNode.push(root, "3");
    final DoubleNode nodeB = DoubleNode.push(root, "nodeB");

    DoubleNode.dequeue(nodeA);
    DoubleNode.pop(nodeB);

    DoubleNode.insertBefore(node2, "1.5");
    DoubleNode.insertAfter(node2, "2.5");

    DoubleNode.remove(node2);

    printFF(root);
    StdOut.println("---");
    printRW(root);
  }

  private static void printFF(final DoubleNode node) {
    DoubleNode ref = node;
    while (ref.prev() != null) {
      ref = ref.prev();
    }
    while (ref != null) {
      StdOut.println(ref);
      ref = ref.next();
    }
  }

  private static void printRW(final DoubleNode node) {
    DoubleNode ref = node;
    while (ref.next() != null) {
      ref = ref.next();
    }
    while (ref != null) {
      StdOut.println(ref);
      ref = ref.prev();
    }
  }
}
