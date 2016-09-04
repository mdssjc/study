package com.github.mdssjc.algorithms.datastructure.queue;

import java.util.Iterator;

/**
 * FIFO Queue.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 * @param <Item>
 *          Tipo de Dado
 */
public interface Queue<Item> extends Iterable<Item> {

  /**
   * Enfileira um item.
   *
   * @param item
   *          Item a ser inserido
   */
  void enqueue(Item item);

  /**
   * Desenfileira um item.
   *
   * @return Primeiro item
   */
  Item dequeue();

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
  Iterator<Item> iterator();
}
