package com.github.mdssjc.algorithms.stack;

/**
 * Interface da Estrutura de Dado Stack - Pilha.
 *
 * @author Marcelo dos Santos
 * @param <T>
 *          Tipo de Dado
 */
public interface Stack<T> {

  /**
   * Empilha o item.
   *
   * @param item
   *          Item a ser inserido
   */
  void push(T item);

  /**
   * Desempilha o item.
   *
   * @return T Último item
   */
  T pop();

  /**
   * Verifica se a pilha está vazia.
   *
   * @return boolean Resultado da verificação
   */
  boolean isEmpty();

  /**
   * Retorna a quantidade de itens na pilha.
   *
   * @return int Quantidade de itens
   */
  int size();
}
