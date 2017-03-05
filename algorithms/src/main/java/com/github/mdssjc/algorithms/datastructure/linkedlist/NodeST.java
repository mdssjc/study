package com.github.mdssjc.algorithms.datastructure.linkedlist;

import lombok.Data;

/**
 * Classe de composição da Linked List Symbol Table.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
@Data
public class NodeST<Key, Value> {

  public Key key;
  public Value value;
  public NodeST<Key, Value> next;
}
