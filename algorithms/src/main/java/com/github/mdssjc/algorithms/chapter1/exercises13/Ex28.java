package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 28.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex28 {

  public static void main(final String[] args) {
    Executor.execute(Ex28.class, args);

    final Node<Integer> nodeRoot = new Node<>();
    nodeRoot.item = 0;
    final Node<Integer> node1 = new Node<>();
    node1.item = 1;
    nodeRoot.next = node1;
    final Node<Integer> node2 = new Node<>();
    node2.item = 2;
    node1.next = node2;
    final Node<Integer> node3 = new Node<>();
    node3.item = 3;
    node2.next = node3;

    final int max = max(nodeRoot);
    StdOut.println(max);
  }

  private static int max(final Node<Integer> node) {
    if (node == null) {
      return 0;
    }
    return max(node.item, node.next);
  }

  private static int max(final Integer acc, final Node<Integer> node) {
    if (node == null) {
      return acc;
    }
    return max(acc + node.item, node.next);
  }
}
