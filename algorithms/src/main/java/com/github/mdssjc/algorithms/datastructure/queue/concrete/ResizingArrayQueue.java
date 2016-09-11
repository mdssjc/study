package com.github.mdssjc.algorithms.datastructure.queue.concrete;

import java.util.Iterator;

import com.github.mdssjc.algorithms.datastructure.queue.Queue;

/**
 * Implementação de Queue (Fila) com capacidade redimensionável.
 * 
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public class ResizingArrayQueue<T> implements Queue<T> {

  @Override
  public void enqueue(T item) {
  }

  @Override
  public T dequeue() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
