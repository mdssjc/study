package com.github.mdssjc.algorithms.datastructure.symbol_table;

import java.util.Iterator;

/**
 * Symbol Table.
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 *
 * @author Marcelo dos Santos
 */
public interface ST<Key, Value> extends Iterable<Key> {

  /**
   * Coloca o par chave-valor na tabela.
   * (remove a chave da tabela se o valor é null)
   *
   * @param key
   *     A chave
   * @param val
   *     O valor
   */
  void put(Key key, Value val);

  /**
   * Valor da chave.
   * (null se a chave não existe)
   *
   * @param key
   *     A chave
   *
   * @return O valor requisitado
   */
  Value get(Key key);

  /**
   * Remove a chave (e seu valor) da tabela.
   *
   * @param key
   *     A chave requisitada
   */
  default void delete(Key key) {
    put(key, null);
  }

  /**
   * Existe a chave na tabela?
   *
   * @param key
   *     A chave
   *
   * @return O resultado do predicado
   */
  default boolean contains(Key key) {
    return get(key) != null;
  }

  /**
   * Está vazia a tabela?
   *
   * @return O resultado do predicado
   */
  default boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Número de chaves na tabela.
   *
   * @return O total de chaves
   */
  int size();

  /**
   * Todas as chaves da tabela.
   *
   * @return O iterator com as chaves
   */
  @Override
  Iterator<Key> iterator();
}
