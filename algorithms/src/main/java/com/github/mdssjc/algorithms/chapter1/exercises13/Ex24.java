package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 24.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex24 {

  public static void main(final String[] args) {
    Executor.execute(Ex24.class, args);

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

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);

    removeAfter(nodeA);

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);
  }

  private static void removeAfter(final Node<String> node) {
    if (node != null && node.next != null) {
      node.next = null;
    }
  }
}
