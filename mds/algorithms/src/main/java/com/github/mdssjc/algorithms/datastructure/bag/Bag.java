package com.github.mdssjc.algorithms.datastructure.bag;

import java.util.Iterator;

/**
 * Interface da Estrutura de Dado Bag.
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
