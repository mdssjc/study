package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 26.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex26 {

  public static void main(final String[] args) {
    Executor.execute(Ex26.class, args);

    final Node<String> nodeRoot = new Node<>();
    nodeRoot.item = "root";
    final Node<String> nodeA = new Node<>();
    nodeA.item = "node a";
    nodeRoot.next = nodeA;
    final Node<String> nodeB = new Node<>();
    nodeB.item = "node b";
    nodeA.next = nodeB;
    final Node<String> nodeA2 = new Node<>();
    nodeA2.item = "node a";
    nodeB.next = nodeA2;
    final Node<String> nodeC = new Node<>();
    nodeC.item = "node c";
    nodeA2.next = nodeC;

    final String key = "node a";

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);

    remove(nodeRoot, key);

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);
  }

  private static void remove(final Node<String> node, final String key) {
    if (node != null) {
      if (node.next != null && node.item.equals(key)) {
        node.item = node.next.item;
        node.next = node.next.next;
      }
      remove(node.next, key);
    }
  }
}
