package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 30.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex30 {

  public static void main(final String[] args) {
    Executor.execute(Ex30.class, args);

    Node<String> nodeRoot = new Node<>();
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

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);

    nodeRoot = reverse(nodeRoot);

    new LinkedListIterator<>(nodeRoot).forEachRemaining(StdOut::println);
  }

//  private public static Node reverse(final Node x) {
//    Node first = x;
//    Node reverse = null;
//    while (first != null) {
//      final Node second = first.next;
//      first.next = reverse;
//      reverse = first;
//      first = second;
//    }
//    return reverse;
//  }

  private static Node reverse(final Node first) {
    if (first == null) {
      return null;
    }
    if (first.next == null) {
      return first;
    }
    final Node second = first.next;
    final Node rest = reverse(second);
    second.next = first;
    first.next = null;
    return rest;
  }
}
