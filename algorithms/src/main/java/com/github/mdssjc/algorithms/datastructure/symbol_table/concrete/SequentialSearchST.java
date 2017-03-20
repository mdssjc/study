package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.symbol_table.ST;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Implementação de Symbol Table com Busca Sequencial.
 *
 * @author Marcelo dos Santos
 *
 * @param <Key>
 *     O tipo de dado da chave
 * @param <Value>
 *     O tipo de dado do valor
 */
public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

  private Node<Key, Value> first;
  private int size;

  @Override
  public void put(final Key key, final Value value) {
    for (Node<Key, Value> x = this.first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.value = value;
        return;
      }
    }
    this.first = new Node<>(key, value, this.first);
    this.size++;
  }

  @Override
  public Value get(final Key key) {
    for (Node<Key, Value> x = this.first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.value;
      }
    }
    return null;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Iterable<Key> keys() {
    return null;
  }

  @Data
  @AllArgsConstructor
  public static class Node<Key, Value> {

    public Key key;
    public Value value;
    public Node<Key, Value> next;
  }
}
