package com.github.mdssjc.algorithms.datastructure.linkedlist;

import lombok.Data;

/**
 * Classe de composição da Linked List - Lista Linkada.
 * </p>
 * Item: valor armazenado
 * Node: próximo nó
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
@Data
public class Node<T> {

  public T       item;
  public Node<T> next;
}
