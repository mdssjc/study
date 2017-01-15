package com.github.mdssjc.algorithms.datastructure.stack.concrete;

import com.github.mdssjc.algorithms.datastructure.iterators.LinkedListIterator;
import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Implementação de Stack (Pilha) com Linked List (Lista Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class StackLinkedList<T> implements Stack<T> {

  private Node<T> first;
  private int     size;

  @Override
  public void push(final T item) {
    final Node<T> oldfirst = this.first;

    this.first = new Node<>();
    this.first.item = item;
    this.first.next = oldfirst;

    this.size++;
  }

  @Override
  public T pop() {
    final T item = this.first.item;

    this.first = this.first.next;

    this.size--;

    return item;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator<>(this.first);
  }

  public static void main(final String[] args) {
    final Stack<String> stack = new StackLinkedList<>();

    while (!StdIn.isEmpty()) {
      final String s = StdIn.readString();
      if (!s.equals("-")) {
        stack.push(s);
      } else if (!stack.isEmpty()) {
        StdOut.print(stack.pop() + " ");
      }
      StdOut.println("(" + stack.size() + " left on stack)");
    }
  }
}
