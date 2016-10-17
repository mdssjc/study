package com.github.mdssjc.dp.strategy.concrete;

import com.github.mdssjc.dp.strategy.Strategy;

/**
 * Implementação padrão do Algorithm.
 *
 * @author Marcelo dos Santos
 *
 */
public class NullAlgorithm implements Strategy {

  @Override
  public void execute() {
    System.out.println("");
  }
}
