package com.github.mdssjc.algorithms.datastructure.linkedlist;

import lombok.Data;

/**
 * Classe de composição da Doubly Linked List - Lista Duplamente Linkada.
 * <p>
 * Item: valor armazenado
 * Node P: nó anterior
 * Node N: próximo nó
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
@Data
public class DoubleNode<T> {

  public T item;
  public DoubleNode<T> previous;
  public DoubleNode<T> next;
}
