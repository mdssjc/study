package com.github.mdssjc.algorithms.datastructure.stack;

import java.util.Iterator;

/**
 * Stack (Pilha) - Pushdown (LIFO) Stack.
 * <p>
 * Interface da estrutura de dado.
 * Examina o item mais recentemente adicionado.
 *
 * @author Marcelo dos Santos
 *
 * @param <T>
 *          Tipo de Dado
 */
public interface Stack<T> extends Iterable<T> {

  /**
   * Empilha um item.
   *
   * @param item
   *          Item a ser inserido
   */
  void push(T item);

  /**
   * Desempilha um item.
   *
   * @return T Último item
   */
  T pop();

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
  Iterator<T> iterator();
}
