package com.github.mdssjc.algorithms.chapter01;

/**
 * Interface
 * Stack : Pilha
 *
 * @author Marcelo dos Santos
 * @param <T> Tipo de Dado
 */
public interface Stack<T> {

    /**
     * Insere um novo item na pilha
     *
     * @param item
     */
    void push(T item);

    /**
     * Remove e retorna o item mais recente
     *
     * @return <T> Último item adicionado
     */
    T pop();

    /**
     * Verifica se a pilha está vazia
     *
     * @return boolean Vazia ou não
     */
    boolean isEmpty();

    /**
     * Número de itens na pilha
     *
     * @return int Quantidade de itens
     */
    int size();
}
