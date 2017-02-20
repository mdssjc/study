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
