package com.github.mdssjc.algorithms.datastructure.priority_queue;

/**
 * Priority Queue.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     Tipo da chave
 */
public interface PriorityQueue<Key extends Comparable<Key>> {

  /**
   * Insere uma chave.
   *
   * @param v
   *     a chave
   */
  void insert(Key v);

  /**
   * Remove uma chave.
   *
   * @return a chave removida
   */
  Key delete();

  /**
   * Predicado: a Priority Queue está vazia?
   *
   * @return resultdo do predicado
   */
  boolean isEmpty();

  /**
   * Retorna o número total de chaves.
   *
   * @return número de chaves
   */
  int size();
}
