package com.github.mdssjc.algorithms.datastructure.stack.concrete;

import java.util.Iterator;

import com.github.mdssjc.algorithms.datastructure.linkedlist.Node;
import com.github.mdssjc.algorithms.datastructure.stack.Stack;
import com.github.mdssjc.algorithms.datastructure.stack.concrete.iterators.StackLinkedListIterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import lombok.Getter;

/**
 * Implementação de Stack (Pilha) com Linked List (Lista Linkada).
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *          Tipo de Dado
 */
public class StackLinkedList<Item> implements Stack<Item>, Iterable<Item> {

  @Getter
  private Node<Item> first;
  private int        size;

  @Override
  public void push(final Item item) {
    final Node<Item> oldfirst = this.first;

    this.first = new Node<Item>();
    this.first.setItem(item);
    this.first.setNext(oldfirst);

    this.size++;
  }

  @Override
  public Item pop() {
    final Item item = this.first.getItem();

    this.first = this.first.getNext();

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
  public Iterator<Item> iterator() {
    return new StackLinkedListIterator<Item>(this);
  }

  public static void main(final String[] args) {
    final StackLinkedList<String> stack = new StackLinkedList<>();

    while (!StdIn.isEmpty()) {
      final String s = StdIn.readString();
      if (s.equals("-")) {
        StdOut.print(stack.pop() + " ");
      } else {
        stack.push(s);
      }
    }
  }
}
