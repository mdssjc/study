package com.github.mdssjc.algorithms.datastructure.symbol_table.concrete;

import com.github.mdssjc.algorithms.datastructure.linkedlist.NodeST;
import com.github.mdssjc.algorithms.datastructure.symbol_table.ST;

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

  private NodeST<Key, Value> first;
  private int size;

  @Override
  public void put(final Key key, final Value value) {
    for (NodeST<Key, Value> x = this.first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.value = value;
        return;
      }
    }
    this.first = new NodeST<>(key, value, this.first);
    this.size++;
  }

  @Override
  public Value get(final Key key) {
    for (NodeST<Key, Value> x = this.first; x != null; x = x.next) {
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
}
