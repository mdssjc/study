package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 20.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex20 {

  public static void main(final String[] args) {
    Executor.execute(Ex20.class, args);

    final Node<String> nodeRoot = new Node<>();
    nodeRoot.item = "root";
    final Node<String> nodeA = new Node<>();
    nodeA.item = "node a";
    nodeRoot.next = nodeA;
    final Node<String> nodeB = new Node<>();
    nodeB.item = "node b";
    nodeA.next = nodeB;
    final Node<String> nodeC = new Node<>();
    nodeC.item = "node c";
    nodeB.next = nodeC;

    final int k = 2;

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);

    delete(nodeRoot, k);

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);
  }

  private static void delete(final Node<String> node, final int k) {
    int count = 0;

    Node ref = node;
    while (ref != null) {
      count++;
      if (count == k) {
        ref.next = ref.next.next;
        break;
      }
      ref = ref.next;
    }
  }
}
