package com.github.mdssjc.algorithms.chapter01;

/**
 * Stack of <T> data type
 *
 * @author Marcelo dos Santos
 * @param <T> Data type
 */
public interface Stack<T> {

    /**
     * Insert a new string onto stack
     *
     * @param item
     */
    void push(T item);

    /**
     * Remove and return the string most recently added
     *
     * @return
     */
    T pop();

    /**
     * Is the stack empty?
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Number of strings on the stack
     *
     * @return int
     */
    int size();
}
