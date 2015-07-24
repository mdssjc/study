package com.github.mdssjc.algorithms.chapter01;

/**
 * Linked Stack Of Strings
 *
 * @author Marcelo dos Santos
 */
public class LinkedStackOfStrings implements Stack<String> {

    private Node first = null;

    private class Node {

        String item;
        Node next;
    }

    @Override
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    @Override
    public String pop() {
        String item = first.item;
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
