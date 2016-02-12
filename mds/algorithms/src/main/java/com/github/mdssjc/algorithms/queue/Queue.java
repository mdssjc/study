package com.github.mdssjc.algorithms.queue;

/**
 * Interface da Estrutura de Dado Queue - Fila.
 *
 * @author Marcelo dos Santos
 * @param <Item>
 *          Tipo de Dado
 */
public interface Queue<Item> {

  /**
   * Enfileira o item.
   *
   * @param item
   *          Item a ser inserido
   */
  void enqueue(Item item);

  /**
   * Desenfileira o item.
   *
   * @return Primeiro item
   */
  Item dequeue();

  /**
   * Verifica se a fila está vazia.
   *
   * @return boolean Resultado da verificação
   */
  boolean isEmpty();

  /**
   * Retorna a quantidade de itens na fila.
   *
   * @return int Quantidade de itens
   */
  int size();
}
