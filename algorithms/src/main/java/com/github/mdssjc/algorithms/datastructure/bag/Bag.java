package com.github.mdssjc.algorithms.datastructure.bag;

import java.util.Iterator;

/**
 * Bag.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 * @param <Item>
 *          Tipo de Dado
 */
public interface Bag<Item> extends Iterable<Item> {

  /**
   * Adiciona um item.
   *
   * @param item
   *          Item a ser adicionado
   */
  void add(Item item);

  /**
   * Predicado para Bag vazio.
   * 
   * @return boolean Valor do predicato
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
  Iterator<Item> iterator();
}
