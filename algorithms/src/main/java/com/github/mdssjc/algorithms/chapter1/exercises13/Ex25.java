package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 25.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex25 {

  public static void main(final String[] args) {
    Executor.execute(Ex25.class, args);

    final Node<String> nodeRoot = new Node<>();
    nodeRoot.item = "root";
    final Node<String> nodeA = new Node<>();
    nodeA.item = "node a";
    final Node<String> nodeB = new Node<>();
    nodeB.item = "node b";
    final Node<String> nodeC = new Node<>();
    nodeC.item = "node c";

    nodeRoot.next = nodeA;
    nodeA.next = nodeB;
    nodeB.next = nodeC;

    final Node<String> nodeRoot2 = new Node<>();
    nodeRoot2.item = "root 2";
    final Node<String> nodeA2 = new Node<>();
    nodeA2.item = "node a";

    nodeRoot2.next = nodeA2;

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);

    insertAfter(nodeRoot, nodeRoot2);

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);
  }

  private static void insertAfter(final Node<String> node1, final Node<String> node2) {
    if (node1 != null) {
      Node<String> ref = node1.next;
      while (ref.next != null) {
        ref = ref.next;
      }
      ref.next = node2;
    }
  }
}
