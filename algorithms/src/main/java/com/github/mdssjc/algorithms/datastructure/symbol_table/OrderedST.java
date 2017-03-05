package com.github.mdssjc.algorithms.datastructure.symbol_table;

/**
 * Ordered Symbol Table.
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 *
 * @author Marcelo dos Santos
 */
public interface OrderedST<Key extends Comparable<Key>, Value> extends ST {

  /**
   * A menor chave.
   *
   * @return A chave requisitada
   */
  Key min();

  /**
   * A maior chave.
   *
   * @return A chave requisitada
   */
  Key max();

  /**
   * A maior chave menor ou igual para a chave de comparação.
   *
   * @param key
   *     Chave de comparação
   *
   * @return A chave requisitada
   */
  Key floor(Key key);

  /**
   * A menor chave maior ou igual para a chave de comparação.
   *
   * @param key
   *     Chave de comparação
   *
   * @return A chave requisitada
   */
  Key ceiling(Key key);

  /**
   * Número de chaves menor do que a chave de comparação.
   *
   * @param key
   *     Chave de comparação
   *
   * @return A quantidade de chaves
   */
  int rank(Key key);

  /**
   * Recupera a chave no rank k.
   *
   * @param k
   *     Valor do rank
   *
   * @return A chave requisitada
   */
  Key select(int k);

  /**
   * Remove a menor chave.
   */
  default void deleteMin() {
    delete(min());
  }

  /**
   * Remove a maior chave.
   */
  default void deleteMax() {
    delete(max());
  }

  /**
   * Número de chaves entre [lo..hi].
   *
   * @param lo
   *     Valor menor
   * @param hi
   *     Valor maior
   *
   * @return A quantidade de chaves
   */
  default int size(Key lo, Key hi) {
    if (hi.compareTo(lo) < 0) {
      return 0;
    } else if (contains(hi)) {
      return rank(hi) - rank(lo) + 1;
    } else {
      return rank(hi) - rank(lo);
    }
  }

  /**
   * Chaves entre [lo..hi], em ordem crescente.
   *
   * @param lo
   *     Valor menor
   * @param hi
   *     Valor maior
   *
   * @return O iterator com as chaves
   */
  Iterable<Key> keys(Key lo, Key hi);

  /**
   * Todas as chaves da tabela, em ordem crescente.
   *
   * @return O iterator com as chaves
   */
  default Iterable<Key> keys() {
    return keys(min(), max());
  }
}
