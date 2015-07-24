package com.github.mdssjc.algorithms.chapter01;

/**
 * Stack: Pilha implementada por ligação de nós
 *
 * @author Marcelo dos Santos
 * @param <T> Tipo de dado
 */
public class LinkedStack<T> implements Stack<T> {

    private Node first;

    public LinkedStack() {
        this.first = null;
    }

    private class Node {

        T item;
        Node next;
    }

    @Override
    public void push(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        Node node = first;
        int size = 0;

        while (node != null) {
            node = node.next;
            size++;
        }

        return size;
    }
}
