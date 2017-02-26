package com.github.mdssjc.algorithms.chapter2.exercises24;

import com.github.mdssjc.algorithms.datastructure.priority_queue.PriorityQueue;
import com.github.mdssjc.algorithms.datastructure.priority_queue.concrete.OrderedArrayMaxPQ;
import com.github.mdssjc.algorithms.datastructure.priority_queue.concrete.OrderedLinkedListMaxPQ;
import com.github.mdssjc.algorithms.datastructure.priority_queue.concrete.UnorderedArrayMaxPQ;
import com.github.mdssjc.algorithms.datastructure.priority_queue.concrete.UnorderedLinkedListMaxPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 3.
 *
 * @author Marcelo dos Santos
 *
 */
public class Ex3 {

  public static void main(final String[] args) {
    final OrderedArrayMaxPQ oamPQ = new OrderedArrayMaxPQ(10);
    final UnorderedArrayMaxPQ uamPQ = new UnorderedArrayMaxPQ(10);
    final OrderedLinkedListMaxPQ ollmPQ = new OrderedLinkedListMaxPQ();
    final UnorderedLinkedListMaxPQ ullmPQ = new UnorderedLinkedListMaxPQ<>();

    StdOut.println("OrderedArrayMaxPQ");
    run(oamPQ);
    StdOut.println("UnorderedArrayMaxPQ");
    run(uamPQ);
    StdOut.println("OrderedLinkedListMaxPQ");
    run(ollmPQ);
    StdOut.println("UnorderedLinkedListMaxPQ");
    run(ullmPQ);
  }

  private static void run(final PriorityQueue pq) {
    pq.insert("this");
    pq.insert("is");
    pq.insert("a");
    pq.insert("test");
    while (!pq.isEmpty()) {
      StdOut.println(pq.delete());
    }
  }
}
