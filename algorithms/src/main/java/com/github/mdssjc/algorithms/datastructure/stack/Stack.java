package com.github.mdssjc.algorithms.datastructure.stack;

import java.util.Iterator;

/**
 * Pushdown (LIFO) Stack.
 * <p>
 * Interface da estrutura de dado.
 *
 * @author Marcelo dos Santos
 * @param <Item>
 *          Tipo de Dado
 */
public interface Stack<Item> extends Iterable<Item> {

  /**
   * Empilha um item.
   *
   * @param item
   *          Item a ser inserido
   */
  void push(Item item);

  /**
   * Desempilha um item.
   *
   * @return T Último item
   */
  Item pop();

  /**
   * Predicado para Stack vazio.
   * 
   * @return boolean Resultado do predicato
   */
  boolean isEmpty();

  /**
   * Retorna a quantidade de itens na Stack.
   *
   * @return int Quantidade de itens
   */
  int size();

  /**
   * Retorna o iterador da Stack.
   *
   * @return Iterador da Stack
   */
  @Override
  Iterator<Item> iterator();
}
