package com.github.mdssjc.dp.strategy.context;

import com.github.mdssjc.dp.strategy.Strategy;
import com.github.mdssjc.dp.strategy.concrete.NullAlgorithm;

/**
 * Classe Abstrata Implementation X.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class ImplementationX {

  private Strategy algorithm;

  public ImplementationX() {
    this.algorithm = new NullAlgorithm();
  }

  public void setAlgorithm(final Strategy algorithm) {
    this.algorithm = algorithm;
  }

  public void useAlgorithm() {
    this.algorithm.execute();
  }
}
