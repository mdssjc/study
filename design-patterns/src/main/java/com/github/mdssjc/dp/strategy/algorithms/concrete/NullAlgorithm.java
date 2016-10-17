package com.github.mdssjc.dp.strategy.algorithms.concrete;

import com.github.mdssjc.dp.strategy.algorithms.Algorithm;

/**
 * Implementação padrão do Algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
public class NullAlgorithm implements Algorithm {

  @Override
  public void execute() {
    System.out.println("");
  }
}
