package com.github.mdssjc.algorithms.datastructure.bag;

import java.util.Iterator;

/**
 * Bag.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 * @param <T>
 *          Tipo de Dado
 */
public interface Bag<T> extends Iterable<T> {

  /**
   * Adiciona um item.
   *
   * @param item
   *          Item a ser adicionado
   */
  void add(T item);

  /**
   * Predicado para Bag vazio.
   * 
   * @return boolean Resultado do predicato
   */
  boolean isEmpty();

  /**
   * Retorna a quantidade de itens no Bag.
   *
   * @return int Quantidade de itens
   */
  int size();

  /**
   * Retorna o iterador do Bag.
   *
   * @return Iterador do Bag
   */
  @Override
  Iterator<T> iterator();
}
