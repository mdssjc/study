package com.github.mdssjc.algorithms.datastructure.queue;

import java.util.Iterator;

/**
 * FIFO Queue.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 * @param <T>
 *          Tipo de Dado
 */
public interface Queue<T> extends Iterable<T> {

  /**
   * Enfileira um item.
   *
   * @param item
   *          Item a ser inserido
   */
  void enqueue(T item);

  /**
   * Desenfileira um item.
   *
   * @return Primeiro item
   */
  T dequeue();

  /**
   * Predicado para Queue vazio.
   * 
   * @return boolean Resultado do predicato
   */
  boolean isEmpty();

  /**
   * Retorna a quantidade de itens na Queue.
   *
   * @return int Quantidade de itens
   */
  int size();

  /**
   * Retorna o iterador da Queue.
   *
   * @return Iterador da Queue
   */
  @Override
  Iterator<T> iterator();
}
