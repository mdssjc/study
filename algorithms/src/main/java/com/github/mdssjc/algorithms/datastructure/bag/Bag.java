package com.github.mdssjc.algorithms.datastructure.bag;

import java.util.Iterator;

/**
 * Bag.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 *
 * @param <Item>
 *     o tipo genérico de um item neste bag
 */
public interface Bag<Item> extends Iterable<Item> {

  /**
   * Adiciona o item para este bag.
   *
   * @param item
   *     O item para para adicionar para este bag
   */
  void add(Item item);

  /**
   * Predicado: retorna true se este bag está vazio.
   *
   * @return {@code true} se este bag está vazio;
   *         {@code false} caso contrário
   */
  boolean isEmpty();

  /**
   * Retorna o número de itens neste bag.
   *
   * @return o número de itens neste bag
   */
  int size();

  /**
   * Retorna um iterator que itera sobre os itens neste bag em ordem arbitrária.
   *
   * @return um iterator que itera sobre os itens neste bag em ordem arbitrária
   */
  @Override
  Iterator<Item> iterator();
}
