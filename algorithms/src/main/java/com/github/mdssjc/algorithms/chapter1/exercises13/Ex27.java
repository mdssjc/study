package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 27.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex27 {

  public static void main(final String[] args) {
    Executor.execute(Ex27.class, args);

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
    int total = 0;

    Node<Integer> ref = node;
    while (ref != null) {
      total += ref.item;
      ref = ref.next;
    }

    return total;
  }
}
