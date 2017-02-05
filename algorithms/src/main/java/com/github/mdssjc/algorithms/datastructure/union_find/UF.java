package com.github.mdssjc.algorithms.datastructure.union_find;

/**
 * Union Find (UF).
 *
 * @author Marcelo dos Santos
 *
 */
public interface UF {

  /**
   * Adiciona conexão entre p e q.
   *
   * @param p
   *     Site p
   * @param q
   *     Site q
   */
  void union(int p, int q);

  /**
   * Identifica o componente para p (0 a N-1).
   *
   * @param p
   *     Site p
   *
   * @return Identificação do site
   */
  int find(int p);

  /**
   * Retorna true se p e q estão no mesmo componente.
   *
   * @param p
   *     Site p
   * @param q
   *     Site q
   *
   * @return Resultado do predicado
   */
  default boolean connected(final int p, final int q) {
    return find(p) == find(q);
  }

  /**
   * Número de componentes.
   *
   * @return Resultado da contagem
   */
  int count();
}
