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
   * Insere uma chave na priority queue.
   *
   * @param v
   *     Valor da chave
   */
  void insert(Key v);

  /**
   * Retorna a maior chave.
   *
   * @return a chave
   */
  Key max();

  /**
   * Retorna e remove a maior chave.
   *
   * @return a chave
   */
  Key delMax();

  /**
   * Predicado: a priority queue está vazia?
   *
   * @return resultdo do predicado
   */
  boolean isEmpty();

  /**
   * Retorna o número de chaves do priority queue.
   *
   * @return número de chaves
   */
  int size();

  /**
   * Retorna a Priority Queue.
   *
   * @return a pq
   */
  Key[] getPq();

  default boolean less(final int i, final int j) {
    return getPq()[i].compareTo(getPq()[j]) < 0;
  }

  default void exch(final int i, final int j) {
    final Key t = getPq()[i];
    getPq()[i] = getPq()[j];
    getPq()[j] = t;
  }

  default void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k / 2, k);
      k = k / 2;
    }
  }

  default void sink(int k) {
    while (2 * k <= size()) {
      int j = 2 * k;
      if (j < size() && less(j, j + 1)) j++;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
    }
  }
}
