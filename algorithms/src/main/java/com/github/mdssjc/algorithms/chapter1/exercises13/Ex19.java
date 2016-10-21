package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 19.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Ex19 {

  public static void main(final String[] args) {
    Executor.execute(Ex19.class, args);

    Node first = create();

    if (first.next == null) {
      first = null;
    } else {
      Node temp = first;
      while (temp.next.next != null) {
        temp = temp.next;
      }
      temp.next = null;
    }

    while (first != null) {
      StdOut.println(first.getItem());
      first = first.next;
    }
  }

  public static Node create() {
    final Node a = new Node();
    a.setItem("A");
    final Node b = new Node();
    b.setItem("B");
    a.setNext(b);
    final Node c = new Node();
    c.setItem("C");
    b.setNext(c);
    return a;
  }
}
